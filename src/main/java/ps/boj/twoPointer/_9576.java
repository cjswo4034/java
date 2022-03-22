package ps.boj.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _9576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0)
            System.out.println(solve(br));
    }

    static int solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        boolean[] visited = new boolean[n];

        for (int i = 0, x, y; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            arr[i][0] = x;
            arr[i][1] = y;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < m; i++) {
            for (int j = arr[i][0]; j <= arr[i][1]; j++) {
                if (visited[j]) continue;
                visited[j] = true;
                ans++;
                break;
            }
        }
        return ans;
    }
}
