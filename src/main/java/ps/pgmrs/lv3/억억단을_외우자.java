package ps.pgmrs.lv3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class 억억단을_외우자 {
    public int[] refact(int e, int[] starts) {
        int[] counts = count(e);
        int[] max = new int[e + 1]; // max[i]: 구간[i~e]에서 가장 많이 등장한 수
        max[e] = e;                 // 구간[e~e]는 e가 가장 많이 등장한다.

        AtomicInteger counter = new AtomicInteger(e - 1);
        IntStream.generate(counter::getAndDecrement)
                .limit(e - 1)
                .forEach(i -> max[i] = counts[i] >= counts[max[i + 1]] ? i : max[i + 1]);

        return Arrays.stream(starts)
                .map(start -> max[start])
                .toArray();
    }

    private int[] count(int e) {
        int[] counts = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e; j++) {
                if (i * j > e) break;
                counts[i * j]++;
            }
        }
        return counts;
    }

    public int[] solution(int e, int[] starts) {
        int[] counts = count(e);

        // dp[i][2]: 구간 [i:e]에서 가장 많이 등장한 {수(0), 횟수(1)}
        // -> dp[i] = counts[i] >= dp[i + 1][1] ? {i, counts[i]} : dp[i + 1]
        int[][] dp = new int[counts.length][2];
        dp[counts.length - 1][0] = counts.length - 1;
        dp[counts.length - 1][1] = counts[counts.length - 1];
        for (int i = counts.length - 2; i >= 0; i--) {
            if (counts[i] >= dp[i + 1][1]) {
                dp[i][0] = i;
                dp[i][1] = counts[i];
            } else {
                dp[i] = dp[i + 1];
            }
        }

        return Arrays.stream(starts)
                .map(start -> dp[start][0])
                .toArray();
    }
}
