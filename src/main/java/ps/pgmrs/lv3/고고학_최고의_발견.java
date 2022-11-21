package ps.pgmrs.lv3;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class 고고학_최고의_발견 {
    private static final Predicate<int[]> isAllZero = row -> Arrays.stream(row).allMatch(value -> value == 0);
    private static final int INF = 100_000_000;

    public int solution(int[][] clockHands) {
        return dfs(clockHands, 0, 0);
    }

    private int dfs(int[][] clockHands, int col, int cost) {
        if (clockHands.length == col)
            return cost + getCountIfAllZero(arrDeepCopy(clockHands), 1);

        return IntStream.rangeClosed(1, 4)
                .map(count -> {
                    rotate(clockHands, 0, col, 1);
                    return dfs(clockHands, col + 1, cost + (count % 4));
                })
                .min()
                .orElse(Integer.MAX_VALUE);
    }

    private int getCountIfAllZero(int[][] clockHands, int row) {
        if (clockHands.length == row) return 0;

        int count = IntStream.range(0, clockHands.length)
                .reduce(0, (acc, cur) -> {
                    int remain = (4 - clockHands[row - 1][cur]) % 4;
                    rotate(clockHands, row, cur, remain);
                    return acc + remain;
                });

        int nextCount = getCountIfAllZero(clockHands, row + 1);
        // nextCount 체크해야되지만 어차피 높은 수라 min 체크할 때 걸림
        return !isAllZero.test(clockHands[row]) ? INF : count + nextCount;
    }

    private void rotate(int[][] clockHands, int row, int col, int count) {
        int len = clockHands.length;
        clockHands[row][col] = (clockHands[row][col] + count) % 4;
        if (row + 1 < len) clockHands[row + 1][col] = (clockHands[row + 1][col] + count) % 4;
        if (col + 1 < len) clockHands[row][col + 1] = (clockHands[row][col + 1] + count) % 4;
        if (row - 1 >= 0) clockHands[row - 1][col] = (clockHands[row - 1][col] + count) % 4;
        if (col - 1 >= 0) clockHands[row][col - 1] = (clockHands[row][col - 1] + count) % 4;
    }

    private int[][] arrDeepCopy(int[][] arr) {
        return Arrays.stream(arr)
                .map(row -> Arrays.copyOf(row, row.length))
                .toArray(int[][]::new);
    }
}
