package Lab2;


import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * handmade sort time: 1707ms
 * build-in sort time: 64ms
 */
public class BenchmarkSorting {
    public static void main(String[] args) {
        int[] array1 = IntStream.generate(() -> ThreadLocalRandom.current().nextInt()).limit(100).toArray();
        int[] array2 = IntStream.generate(() -> ThreadLocalRandom.current().nextInt()).limit(100).toArray();

        long startTime2 = System.currentTimeMillis();
        BenchmarkSorting.mySort(array1);
        long runtime2 = System.currentTimeMillis() - startTime2;
        System.out.println("handmade sort time: " + runtime2 + "ms");

        long startTime = System.currentTimeMillis();
        Arrays.sort(array2);
        long runtime = System.currentTimeMillis() - startTime;
        System.out.println("build-in sort time: " + runtime + "ms");


    }
    /*insertion sort*/
    private static void mySort(int[] array) {
        int in;
        int out;
        for (out = 1; out < array.length; out++) {
            int temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }
}
