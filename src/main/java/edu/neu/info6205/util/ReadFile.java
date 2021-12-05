package edu.neu.info6205.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Class with methods to get String array by reading data files.
 */
public class ReadFile {
    /**
     * Method to get array of Strings by reading the input data file line by line.
     * @param filePath Path of the input data file
     * @return Array of Strings
     * @throws IOException
     */
    public static String[] getStringArray(String filePath) throws IOException {

        Class c = ReadFile.class;

        String line;
        List<String> values = new ArrayList<String>();
        BufferedReader fr = new BufferedReader(new FileReader(filePath));

        while ((line = fr.readLine()) != null)
            values.add(line);

        return values.toArray(new String[0]);
    }

    /**
     * Method to get array of Strings of desired size by appending elements to it and shuffling.
     * @param filePath Path of the input data file
     * @param size Desired size of the output array
     * @return extended and shuffled array of Strings
     * @throws IOException
     */
    public static String[] getExtendedStringArray(String filePath, int size) throws IOException {
        String[] originalArray = getStringArray(filePath);

        List<String> extendedList = new ArrayList<>();

        int originalArrayLength = originalArray.length;

        // Extend the list by appending the elements to the list from the input array
        for (int i = 0; i < size; i++) {
            extendedList.add(originalArray[i % originalArrayLength]);
        }

        Collections.shuffle(extendedList); // Shuffle the extended list

        return extendedList.toArray(new String[0]);
    }
}
