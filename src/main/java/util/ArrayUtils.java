package util;

import java.util.Arrays;

public class ArrayUtils {
    public static <T> void print(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static <T> void print(T[][] array) {
        for (T[] row: array)
            print(row);
    }

    public static void print(int[][] array) {
        for (int[] row: array)
            System.out.println(Arrays.toString(row));
    }
}
