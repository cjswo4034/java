package algorithm.sorting;

import java.util.Arrays;

public interface Sorting {
    void sort(int[] arr);

    default void print(String prefix, int[] arr) {
        System.out.println(prefix + Arrays.toString(arr));
    }

    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    default int[] copyArray(int[] input) {
        int[] output = new int[input.length];
        System.arraycopy(input, 0, output, 0, output.length);
        return output;
    }
}
