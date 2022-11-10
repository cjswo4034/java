package algorithm.sorting.stable;

import algorithm.sorting.Sorting;

public class InsertionSorting implements Sorting {
    @Override
    public void sort(int[] arr) {
        for (int i = 1, n = arr.length; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                change(arr, j - 1, j);
                j--;
            }
        }
    }

    private void change(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
