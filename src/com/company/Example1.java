package com.company;

import java.io.*;

public class Example1 {

    Example1() throws IOException{
        Reader in=null;
        Writer out=null;
        try {
            in = new FileReader("TestFiles\\MyFile1.txt");
            out= new FileWriter("TestFiles\\MyFile2.txt", true);
            int oneByte;
            while ((oneByte = in.read()) != -1) {
                out.append((char)oneByte);
                System.out.print((char)oneByte);
            }
        }
        catch (IOException e) {
            System.out.println("Ошибка!!!! ");
        }
        finally{
            in.close();
            out.close();
        }
    }
}
