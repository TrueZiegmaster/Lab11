package com.company;

import java.io.*;

public class Example4 {
    Example4() throws IOException{
        BufferedReader br = null;
        BufferedWriter bw=null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("TestFiles\\MyFile1.txt"),"cp1251"));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("TestFiles\\MyFile2.txt"),"cp1251"));
            int lineCount = 0;
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                bw.write(lineCount + ": " + s);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка !!!!!!!!");
        }
        finally{
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
