package ps.boj.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 1, e = 1;
        int sum = 0, ans = 0;
        while (true) {
            if (sum >= m) sum -= arr[s++];
            else if (e == n + 1) break;
            else sum += arr[e++];
            if (sum == m) ans++;
        }

        System.out.println(ans);
    }
}
