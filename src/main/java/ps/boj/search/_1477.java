package ps.boj.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        list.add(l);
        if (list.get(0) != 0) list.add(0, 0);

        int s = 1;
        int e = l - 1;
        while (s < e) {
            int mid = (s + e) >> 1;
            int cnt = 0;
            for (int i = 1; i < list.size(); i++) {
                // i번째 휴게소와 i-1번째 휴게소의 거리
                int  dist = list.get(i) - list.get(i - 1);

                // 구간 [i-1, i]에서 mid 간격으로 세울 수 있는 휴게소의 수
                cnt += dist / mid;

                // mid 간격으로 세웠을 때 i 휴게소에 겹쳐져서 하나 뺌
                if (dist % mid == 0) cnt--;
            }

            // 세울 수 있는 휴게소가 m개보다 많다면 구간을 늘림
            if (cnt > m) s = mid + 1;
            else e = mid;
        }

        System.out.println(s);
    }
}
