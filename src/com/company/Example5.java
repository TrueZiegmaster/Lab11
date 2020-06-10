package com.company;

import java.io.*;

public class Example5 {
    Example5() throws IOException{
        BufferedReader br = null;
        PrintWriter out=null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("TestFiles\\MyFile1.txt"),"cp1251"));
            out = new PrintWriter("TestFiles\\MyFile2.txt","cp1251");

            int lineCount = 0;
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }
        }
        catch (IOException e) {
            System.out.println("Ошибка !!!!!!!!");
        }
        finally{
            br.close();
            out.flush();
            out.close();
        }
    }
}
