package edu.neu.info6205.HuskySort.huskySort;

import edu.neu.info6205.HuskySort.huskySortUtils.HuskyCoderFactory;
import edu.neu.info6205.MSDRadixSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PureHuskySortTest {

    @Test
    public void testSort1(){
        String[] input = {"दांत", "ड्राइव", "प्रसार","करेगा","बसा","पानी","शामिल","घर","युद्ध","समाधान"};
        String[] expected = {"करेगा", "घर", "ड्राइव", "दांत", "पानी", "प्रसार", "बसा", "युद्ध", "शामिल", "समाधान"};

        final PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false);
        sorter.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort2(){
        String[] input = "वह प्रोग्रामर कंप्यूटर का उपयोग करता है".split(" ");
        String[] expected = {"उपयोग", "कंप्यूटर", "करता", "का", "प्रोग्रामर", "वह", "है"};

        final PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false);
        sorter.sort(input);

        assertArrayEquals(expected, input);
    }
}
