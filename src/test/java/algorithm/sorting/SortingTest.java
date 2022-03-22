package algorithm.sorting;

import algorithm.sorting.stable.*;
import algorithm.sorting.unstable.*;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortingTest {
    static final int MIN_LENGTH = 2000;
    static final int MAX_LENGTH = 50000;

    int[] arr, sortedArr;

    @TestFactory
    Stream<DynamicTest> testsForStableSorting() {
        return Stream.of(BubbleSorting.class, InsertionSorting.class, MergeSorting.class, CountSorting.class, RadixSorting.class)
                .map(clazz -> DynamicTest.dynamicTest(clazz.getSimpleName(), () -> sort(clazz)));
    }

    @TestFactory
    Stream<DynamicTest> testsForUnstableSorting() {
        return Stream.of(HeapSorting.class, QuickSorting.class, SelectionSorting.class, ShellSorting.class)
                .map(clazz -> DynamicTest.dynamicTest(clazz.getSimpleName(), () -> sort(clazz)));
    }

    void sort(Class<? extends Sorting> clazz) throws Exception {
        init(clazz.getSimpleName());

        Sorting sorting = clazz.getDeclaredConstructor().newInstance();
        sorting.sort(arr);

        assertArrayEquals(sortedArr, arr);

        printProcessTime(sorting);
    }

    void init(String algorithm) {
        System.out.println("=============== [" + algorithm + "] ===============");

        arr = initRandomIntStream(MIN_LENGTH).toArray();
        sortedArr = Arrays.copyOf(arr, arr.length);

        Arrays.sort(sortedArr);
    }

    void printProcessTime(Sorting sorting) {
        int[] randomArr = initRandomIntStream(MAX_LENGTH).toArray();
        int[] sortedArr = IntStream.of(randomArr).sorted().toArray();
        int[] reversedArr = IntStream.of(randomArr).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        printProcessTime(sorting, "Random: ", randomArr);
        printProcessTime(sorting, "Sorted: ", sortedArr);
        printProcessTime(sorting, "Reversed: ", reversedArr);
    }

    void printProcessTime(Sorting sorting, String prefix, int[] arr) {
        long tic = System.currentTimeMillis();

        sorting.sort(arr);

        long toc = System.currentTimeMillis() - tic;

        System.out.println(prefix + toc + "[ms]");
    }

    IntStream initRandomIntStream(int size) {
        return new Random().ints(size, -size * 10, size * 20);
    }
}