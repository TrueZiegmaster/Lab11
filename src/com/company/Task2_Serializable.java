package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task2_Serializable {

    class Film implements Serializable{
        String name;
        int year;
        String country;
        String genre;
        int costUsd;
    }

    Task2_Serializable(){
        try{
            Scanner sc=new Scanner(System.in, StandardCharsets.UTF_8);
            File f1 = new File("TestFiles\\Task2\\Ser\\Films");
            f1.createNewFile();
            FileOutputStream fos = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Введите количество фильмов: ");
            int kol = sc.nextInt();
            sc.nextLine();
            Film[] films = new Film[kol];
            for (int i = 0; i < kol; i++){
                Film film = new Film();
                System.out.println("Введите информацию о фильме: ");
                System.out.print("Название фильма => ");
                film.name=sc.nextLine();
                System.out.print("Год выхода => ");
                film.year=sc.nextInt();
                sc.nextLine();
                System.out.print("Страна => ");
                film.country=sc.nextLine();
                System.out.print("Жанр => ");
                film.genre=sc.nextLine();
                System.out.print("Стоимость проката в USD => ");
                film.costUsd=sc.nextInt();
                sc.nextLine();
                System.out.println(film.name + " " + film.year + " " + film.country + " " + film.genre + " " + film.costUsd);
                films[i] = film;
            }
            for (Film f: films) {
                oos.writeObject(f);
                oos.flush();
            }
            oos.close();

            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream oin = new ObjectInputStream(fis);

            File f2 = new File("TestFiles\\Task2\\Ser\\FilmsRus");
            f2.createNewFile();
            fos = new FileOutputStream(f2);
            oos = new ObjectOutputStream(fos);

            try {
                Film film = (Film) oin.readObject();
                if (film.country.equals("Россия")){
                    System.out.println(film.name + " " + film.year + " " + film.country + " " + film.genre + " " + film.costUsd);
                    oos.writeObject(film);
                }
            }
            catch (ClassNotFoundException e){
            }
            finally {
                oos.flush();
                oos.close();
            }

        }
        catch (IOException e){
        }
    }
}
