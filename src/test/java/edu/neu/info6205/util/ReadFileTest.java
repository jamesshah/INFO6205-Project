package edu.neu.info6205.util;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static junit.framework.TestCase.assertEquals;

public class ReadFileTest {

    private static String filePath = "/home/james/Downloads/shuffledHindi.txt";

    @Test
    public void testGetStringArray() throws IOException, URISyntaxException {
        String[] values = ReadFile.getStringArray(filePath);

        assertEquals(values.length, 37082);
    }

    /*
    Test to get array of more elements than the original array.
     */
    @Test
    public void testGetExtendedStringArray1() throws IOException, URISyntaxException {

        int expectedLength = 1000_000;
        String[] values = ReadFile.getExtendedStringArray(filePath, expectedLength);

        assertEquals(values.length, expectedLength);
    }

    /*
    Test to get array of same number of elements as the original array.
     */
    @Test
    public void testGetExtendedStringArray2() throws IOException, URISyntaxException {

        int expectedLength = 37082;
        String[] values = ReadFile.getExtendedStringArray(filePath, expectedLength);

        assertEquals(values.length, expectedLength);
    }

    /*
    Test to get array of fewer elements than the original array.
     */
    @Test
    public void testGetExtendedStringArray3() throws IOException, URISyntaxException {

        int expectedLength = 32000;
        String[] values = ReadFile.getExtendedStringArray(filePath, expectedLength);

        assertEquals(values.length, expectedLength);
    }
}
