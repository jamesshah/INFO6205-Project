package edu.neu.info6205;

import edu.neu.info6205.util.ReadFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * Main class that works as an entry point for benchmarking various algorithms with various sized elements.
 */
public class Main {

    private static String filePath = "./src/main/resources/shuffledHindi.txt";

    public static void main(String[] args) throws IOException {
        /**
//         * Array of various sizes for benchmarking array
//         */
        int[] sizesOfArray = {8000, 16000, 32000, 64000, 128_000, 256_000,
                        512_000, 1000_000, 2000_000, 4000_000, 8000_000, 16000_000};

        // Running benchmarks for various size of array
        for (int size: sizesOfArray) {

            System.out.println("\n" + "Array size: " + size + "\n");

            String[] arr = ReadFile.getExtendedStringArray(filePath, size);

            assert arr.length == size : "Size of the 'arr' array doesn't match with expected size";
//            BenchmarkDriver.runBenchmark("MSDO", () -> arr, 10);
            BenchmarkDriver.runBenchmark("MSD", () -> arr, 10);
//            BenchmarkDriver.runBenchmark("Tim", () -> arr, 10);
//            BenchmarkDriver.runBenchmark("LSD", () -> arr, 10);
//            BenchmarkDriver.runBenchmark("Husky", () -> arr, 10);
//            BenchmarkDriver.runDPQBenchMark(filePath, size, 10);
        }
    }
}