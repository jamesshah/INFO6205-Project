package edu.neu.info6205;

/**
 * Implementation of Dual Pivot Quick Sort algorithm to sort "Devanagari" strings.
 */
public class DualPivotQuickSort {
    private static void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(String[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(String[] arr, int low, int high)
    {
        if (low < high)
        {
            // piv[] stores left pivot and right pivot.
            // piv[0] means left pivot and
            // piv[1] means right pivot
            int[] piv;
            piv = partition(arr, low, high);

            sort(arr, low, piv[0] - 1);
            sort(arr, piv[0] + 1, piv[1] - 1);
            sort(arr, piv[1] + 1, high);
        }
    }

    static int[] partition(String[] arr, int low, int high)
    {
        if (arr[low].compareTo(arr[high]) > 0)
            swap(arr, low, high);

        // p is the left pivot, and q
        // is the right pivot.
        int j = low + 1;
        int g = high - 1, k = low + 1;
        String p = arr[low], q = arr[high];

        while (k <= g)
        {

            // If elements are less than the left pivot
            if (arr[k].compareTo(p) < 0)
            {
                swap(arr, k, j);
                j++;
            }

            // If elements are greater than or equal
            // to the right pivot
            else if (arr[k].compareTo(q) >= 0)
            {
                while (arr[g].compareTo(q) > 0 && k < g)
                    g--;

                swap(arr, k, g);
                g--;

                if (arr[k].compareTo(p) < 0)
                {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        // Bring pivots to their appropriate positions.
        swap(arr, low, j);
        swap(arr, high, g);

        // Returning the indices of the pivots
        // because we cannot return two elements
        // from a function, we do that using an array.
        return new int[] { j, g };
    }
}
