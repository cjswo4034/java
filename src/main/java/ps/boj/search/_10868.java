package ps.boj.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10868 {
    private static final int MAX = (int) 1e10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int len = getSize(N);
        int[] arr = new int[len * 2];

        Arrays.fill(arr, MAX);
        for (int i = 0; i < N; i++) {
            arr[len + i] = Integer.parseInt(br.readLine());
            update(arr, len + i, arr[len + i]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + len - 1;
            int b = Integer.parseInt(st.nextToken()) + len - 1;
            if (a == b)
                System.out.println(arr[a]);
            else
                System.out.println(find(arr, a, b, 1, len, len * 2));
        }
    }

    static int find(int[] arr, int l, int r, int node, int L, int R) {
        if (r < L || R < l) return MAX;
        if (l <= L && R <= r) return arr[node];
        int mid = (L + R + 1) / 2;
        return Math.min(
                find(arr, l, r, node * 2, L, mid - 1),
                find(arr, l, r, node * 2 + 1, mid, R));
    }

    static void update(int[] arr, int idx, int value) {
        if (idx == 0) return;

        arr[idx] = Math.min(arr[idx], value);
        update(arr, idx / 2, value);
    }

    static int getSize(int n) {
        int i = 1;
        while (i < n) {
            i *= 2;
        }
        return i;
    }
}
