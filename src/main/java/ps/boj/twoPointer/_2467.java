package ps.boj.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int s = 0, e = n - 1;
        int ansS = 0, ansE = 0;
        int min = Integer.MAX_VALUE;
        while (s < e) {
            int sum = Math.abs(arr[s] + arr[e]);
            if (min > sum) {
                min = sum;
                ansS = s;
                ansE = e;
            }

            if (sum == 0) {
                break;
            } else if (arr[s] + arr[e] > 0) {
                e--;
            } else {
                s++;
            }
        }

        System.out.println(arr[ansS] + " " + arr[ansE]);
    }
}