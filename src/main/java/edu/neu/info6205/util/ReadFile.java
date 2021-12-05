package edu.neu.info6205.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class ReadFile {

    public static String[] getStringArray(String filePath) throws IOException, URISyntaxException {

        Class c = ReadFile.class;

        String line;
        List<String> values = new ArrayList<String>();
        BufferedReader fr = new BufferedReader(new FileReader(filePath));

        while ((line = fr.readLine()) != null)
            values.add(line);

        return values.toArray(new String[0]);
    }

    public static String[] getExtendedStringArray(String filePath, int size) throws IOException, URISyntaxException {
        String[] originalArray = getStringArray(filePath);
//        String[] extendedArray = new String[size];
        List<String> extendedList = new ArrayList<>();

        int originalArrayLength = originalArray.length;

        for (int i = 0; i < size; i++) {
            extendedList.add(originalArray[i % originalArrayLength]);
        }

        Collections.shuffle(extendedList); // Shuffle the extended list

        return extendedList.toArray(new String[0]);
    }
}
