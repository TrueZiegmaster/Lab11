package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task1 {
    Task1() throws IOException{
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("TestFiles\\Task1\\Text1.txt"), StandardCharsets.UTF_8));
            out = new PrintWriter("TestFiles\\Task1\\Text2.txt", StandardCharsets.UTF_8);
            int lineCount = 1;
            String s;
            String firstWord = null;
            while ((s = br.readLine()) != null) {
                String[] words = s.split(" ");
                if (firstWord == null){
                    firstWord = words[0];
                }
                int wordsCount = 0;
                for (String word: words)
                    if (word.toLowerCase().charAt(0) == firstWord.toLowerCase().charAt(0))
                        wordsCount ++;
                out.println("Строка: " + lineCount + ". Выбрано слов: " + wordsCount + ". Слова: ");
                for (String word: words)
                    if (word.toLowerCase().charAt(0) == firstWord.toLowerCase().charAt(0))
                        out.println( word);
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка !!!!!!!!");
        }
        finally {
            br.close();
            out.flush();
            out.close();
        }
    }
}
