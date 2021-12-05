package edu.neu.info6205;

import io.cucumber.java.sl.In;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTest {

    @Test
    public void testSort1(){
        String[] input = {"दांत", "ड्राइव", "प्रसार","करेगा","बसा","पानी","शामिल","घर","युद्ध","समाधान"};
        String[] expected = {"करेगा", "घर", "ड्राइव", "दांत", "पानी", "प्रसार", "बसा", "युद्ध", "शामिल", "समाधान"};

        InsertionSort.sort(input, 0, input.length, 0);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort2(){
        String[] input = "वह प्रोग्रामर कंप्यूटर का उपयोग करता है".split(" ");
        String[] expected = {"उपयोग", "कंप्यूटर", "करता", "का", "प्रोग्रामर", "वह", "है"};

        InsertionSort.sort(input, 0, input.length,  0);

        assertArrayEquals(expected, input);
    }
}
