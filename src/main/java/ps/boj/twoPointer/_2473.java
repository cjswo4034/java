package ps.boj.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        long[] ans = new long[3];
        long min = (long) 1e10;
        for (int i = 0; i < n - 2; i++) {
            int s = i + 1;
            int e = n - 1;
            while (s < e) {
                long sum = arr[i] + arr[s] + arr[e];
                if (Math.abs(min) > Math.abs(sum)) {
                    min = sum;
                    ans[0] = arr[i];
                    ans[1] = arr[s];
                    ans[2] = arr[e];
                }

                if (sum >= 0) e--;
                else s++;
            }
        }

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
