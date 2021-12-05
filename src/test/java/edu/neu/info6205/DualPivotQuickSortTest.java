package edu.neu.info6205;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DualPivotQuickSortTest {
    @Test
    public void testSort1(){
        String[] input = {"दांत", "ड्राइव", "प्रसार","करेगा","बसा","पानी","शामिल","घर","युद्ध","समाधान"};
        String[] expected = {"करेगा", "घर", "ड्राइव", "दांत", "पानी", "प्रसार", "बसा", "युद्ध", "शामिल", "समाधान"};

        DualPivotQuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort2(){
        String[] input = "वह प्रोग्रामर कंप्यूटर का उपयोग करता है".split(" ");
        String[] expected = {"उपयोग", "कंप्यूटर", "करता", "का", "प्रोग्रामर", "वह", "है"};

        DualPivotQuickSort.sort(input);

        assertArrayEquals(expected, input);
    }

}
