package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        File file = new File("/Users/maks/IdeaProjects/text file reader/src/com/company/files/file.txt");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String word = scanner.next();

            if (map.containsKey(word)) {
                int count = map.get(word) + 1;
                map.put(word.replaceAll("[,!-().]", ""), count);
            } else {
                map.put(word.replaceAll("[,!-().]", ""), 1);
            }
        }
        scanner.close();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }

    }
}
