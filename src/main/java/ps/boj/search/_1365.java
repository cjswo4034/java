package ps.boj.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = 1;
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[n + 1];
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        mem[1] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < mem[len]) {
                mem[lowerBound(mem, len, arr[i])] = arr[i];
            } else {
                mem[++len] = arr[i];
            }
        }
        System.out.println(n - len);
    }

    static int lowerBound(int[] arr, int len, int value) {
        int l = 1;
        int r = len;
        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] < value) l = m + 1;
            else r = m;
        }
        return l;
    }
}
