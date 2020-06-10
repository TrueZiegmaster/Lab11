package com.company;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task2_RandomAccess {

    Task2_RandomAccess(){
        try {
            File folder = new File("TestFiles\\Task2\\RAF");
            if (!folder.exists())
                folder.mkdir();

            File f1 = new File("TestFiles\\Task2\\RAF\\Films_RAF.txt");
            if (!f1.exists())
                f1.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f1,"rw");
            Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.print("Введите количество фильмов для записи в файл\n" + "=> ");
            int kol = sc.nextInt();
            sc.nextLine();
            String name, country, genre;
            int year, costUsd;
            for (int i = 0; i < kol; i++) {
                System.out.print("Введите название фильма => ");
                name = sc.next();
                rf.seek(rf.length());
                rf.writeUTF(name);
                for (int j = 0; j < 20 - name.length(); j++)
                    rf.writeByte(1);

                System.out.print("Введите год выхода фильма => ");
                year = sc.nextInt();
                sc.nextLine();
                rf.writeInt(year);

                System.out.print("Введите страну => ");
                country = sc.next();
                rf.writeUTF(country);
                for (int j = 0; j < 20 - country.length(); j++)
                    rf.writeByte(1);

                System.out.print("Введите жанр(ы) => ");
                genre = sc.next();
                rf.writeUTF(genre);
                for (int j = 0; j < 20 - genre.length(); j++)
                    rf.writeByte(1);

                System.out.print("Введите стоимость проката в USD => ");
                costUsd = sc.nextInt();
                sc.nextLine();
                rf.writeInt(costUsd);
            }
            rf.close();

            rf = new RandomAccessFile(f1, "r");
            rf.seek(0);

            File f2 = new File("TestFiles\\Task2\\RAF\\RUS_RAF.txt");
            if (!f1.exists())
                f1.createNewFile();
            RandomAccessFile rf1 = new RandomAccessFile(f2,"rw");

            System.out.println("Информация о фильмах");
            System.out.println("Название \t\t Год \t\t Страна \t\t  Жанр \t\t Стоимость проката в USD");
            try{
                while (true){
                    name = rf.readUTF();
                    for (int j = 0; j < 20 - name.length(); j++)
                        rf.readByte();
                    year = rf.readInt();
                    country = rf.readUTF();
                    for (int j = 0; j < 20 - country.length(); j++)
                        rf.readByte();
                    genre = rf.readUTF();
                    for (int j = 0; j < 20 - genre.length(); j++)
                        rf.readByte();
                    costUsd = rf.readInt();
                    System.out.println(name + "\t\t\t" + year + "\t\t\t" + country + "\t\t\t" + genre + "\t\t\t" + costUsd);
                    if (country.equals("Россия")){
                        rf1.writeUTF(name);
                        for (int j = 0; j < 20 - name.length(); j++)
                            rf1.writeByte(1);
                        rf1.writeInt(year);
                        rf1.writeUTF(country);
                        for (int j = 0; j < 20 - country.length(); j++)
                            rf1.writeByte(1);
                        rf1.writeUTF(genre);
                        for (int j = 0; j < 20 - genre.length(); j++)
                            rf1.writeByte(1);
                        rf1.writeInt(costUsd);
                    }
                }
            }
            catch (EOFException e){
            }
            finally {
                rf.close();
                rf1.close();
            }
        }
        catch (IOException e) {
            System.out.println("End of file " + e);
        }
    }
}
