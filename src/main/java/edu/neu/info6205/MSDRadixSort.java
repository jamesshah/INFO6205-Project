package edu.neu.info6205;

/**
 * MSD Radix sort algorithm implemented for "Devanagari" strings (ASCII RANGE - 2304 to 2463)
 * sorting. Changes made to the number of Radixes(R), and storing of characters in the count array,
 * made significant changes in the execution time of the algorithm.
 */
public class MSDRadixSort {
    private static int R = 119;        // radix for "Devanagari" characters
    private static final int CUTOFF = 15; // cutoff for small arrays
    private static String[] aux;       // auxiliary array for distribution

    /**
     *
     * @param s current string being sorted
     * @param d character position in string 's'
     * @return ASCII value of the character at position 'd' in the String 's'.
     */
    private static int charAt(String s, int d)
    {
        if (d < s.length()) {
            return s.charAt(d);
        }
        else return -1;
    }

    /**
     * public sort method
     * @param a Array of Strings to be sorted.
     */
    public static void sort(String[] a)
    {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    /**
     *
     * @param a Array of Strings to be sorted.
     * @param lo Left most position in the array 'a'.
     * @param hi Right most position in the array 'a'.
     * @param d character position for strings to start sorting from.
     */
    private static void sort(String[] a, int lo, int hi, int d)
    {
        // Sort from a[lo] to a[hi], starting at the dth character.
        if (hi <= lo + CUTOFF) {
            InsertionSort.sort(a, lo, hi, d);
            return;
        }
        if(hi <= lo)
            return;
        int[] count = new int[R+2];        // Compute frequency counts.
        for (int i = lo; i <= hi; i++){
            int index = charAt(a[i], d);
//            System.out.println(index);
            if(index >= 2304 && index <= 2423 ){
                count[(index - 2304) + 2]++;
            }
//            System.out.println(index);
        }

        for (int r = 0; r < R+1; r++)      // Transform counts to indices.
            count[r+1] += count[r];
        for (int i = lo; i <= hi; i++) {     // Distribute.
            int index = charAt(a[i], d);
            if(index >= 2304 && index <= 2423 ) {
                aux[count[(index - 2304) + 1]++] = a[i];
            }
        }
        for (int i = lo; i <= hi; i++)     // Copy back.
            a[i] = aux[i - lo];
        // Recursively sort for each character value.
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1);
    }
}
