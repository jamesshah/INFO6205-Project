package edu.neu.info6205;

import edu.neu.info6205.HuskySort.huskySort.PureHuskySort;
import edu.neu.info6205.HuskySort.huskySortUtils.HuskyCoderFactory;
import edu.neu.info6205.util.Benchmark;
import edu.neu.info6205.util.Benchmark_Timer;
import edu.neu.info6205.util.ReadFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Class that runs benchmarks for all the algorithms.
 */
public class BenchmarkDriver {

    /**
     * Runs benchmarks for Dual Pivot Quick Sort algorithm. Somehow, the Benchmark_Timer method doesn't
     * work for Dual Pivot Quick Sort. Thus, we make use of System function to benchmark it.
     *
     * @param filePath input data file path.
     * @param N Size of the array
     * @param runs number of times the function will be called.
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void runDPQBenchMark(String filePath, int N, int runs) throws IOException, URISyntaxException {
        System.out.println("Begin run: Dual Pivot Quick Sort with " + runs + " runs");

        int totalTime = 0;
        for(int i = 0; i< runs; i++){
            String[] input = ReadFile.getExtendedStringArray(filePath, N);

            long startTime = System.currentTimeMillis();
            DualPivotQuickSort.sort(input);
            long endTime = System.currentTimeMillis();

            totalTime += (endTime - startTime);
        }

        System.out.println((totalTime / runs) + " ms");
    }

    /**
     * Private method to run benchmark for MSD, LSD, Tim, Husky sort algorithms.
     * @param algorithm Algorithm to run benchmarks for
     * @param supplier Array of Strings to be sorted in a supplier form
     * @param runs Number of times, the algorithms will run.
     * @throws IOException
     */
    private static void _runBenchmark(String algorithm, Supplier<String[]> supplier, int runs) throws IOException {
        switch (algorithm) {
            case "MSD":
                final Benchmark<String[]> msdBenchmark = new Benchmark_Timer<String[]>(
                        "MSD Radix sort",
                        null,
                        MSDRadixSort::sort,
                        null
                );

                System.out.println((msdBenchmark.runFromSupplier(supplier, runs)) + "ms");
                break;

            case "Tim":
                final Benchmark<String[]> timBenchmark = new Benchmark_Timer<String[]>(
                        "Tim sort",
                        null,
                        TimSort::sort,
                        null
                );

                System.out.println((timBenchmark.runFromSupplier(supplier, runs)) + "ms");
                break;

            case "DPQ":
                final Benchmark<String[]> dpqBenchmark = new Benchmark_Timer<String[]>(
                        "Dual Pivot Quick sort",
                        null,
                        DualPivotQuickSort::sort,
                        null
                );

                System.out.println((dpqBenchmark.runFromSupplier(supplier, runs)) + "ms");
                break;

            case "LSD":
                final Benchmark<String[]> lsdBenchmark = new Benchmark_Timer<String[]>(
                        "LSD Radix sort",
                        null,
                        LSDRadixSort::sort,
                        null
                );

                System.out.println((lsdBenchmark.runFromSupplier(supplier, runs)) + "ms");
                break;

            case "Husky":
                final PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false);
                final Benchmark<String[]> huskyBenchmark = new Benchmark_Timer<String[]>(
                        "Husky sort",
                        null,
                        sorter::sort,
                        null
                );

                System.out.println((huskyBenchmark.runFromSupplier(supplier, runs)) + "ms");
                break;

            case "MSDO":
                final Benchmark<String[]> msdoBenchmark = new Benchmark_Timer<String[]>(
                        "MSD Original Radix sort",
                        null,
                        MSDRadixSortOriginal::sort,
                        null
                );

                System.out.println((msdoBenchmark.runFromSupplier(supplier, runs)) + "ms");
                break;
        }
    }

    /**
     * Public method that calls private method to run the benchmark.
     * @param algorithm The algorithm to be benchmarked.
     * @param supplier Array of Strings to be sorted in a supplier form
     * @param runs Number of times, the algorithms will run.
     * @throws IOException
     */
    public static void runBenchmark(String algorithm, Supplier<String[]> supplier, int runs) throws IOException {
        _runBenchmark(algorithm, supplier, runs);
    }
}
