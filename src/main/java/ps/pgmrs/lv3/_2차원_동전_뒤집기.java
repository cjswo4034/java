package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _2차원_동전_뒤집기 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int[][]) params[0], (int[][]) params[1]);
    }

    public int solution(int[][] begin, int[][] target) {
        int answer = Integer.MAX_VALUE;
        int rows = begin.length, cols = begin[0].length;

        // 행을 비트마스킹으로 바꿈 (0: 흑돌, 1: 백돌)
        int[] from = toBitMaskingArr(begin);
        int[] to = toBitMaskingArr(target);

        // comb: 모든 행의 조합
        for (int comb = 0, len = (1 << rows); comb < len; comb++) {
            int[] flippedArr = Arrays.copyOf(from, rows);
            int count = 0;
            int mask = (1 << cols) - 1;

            // comb와 일치하는 행들을 뒤집음
            for (int row = 0; row < rows; row++) {
                if ((comb & (1 << row)) > 0) {
                    flippedArr[row] = flippedArr[row] ^ mask;
                    count++;
                }
            }

            if (answer <= count) continue;

            for (int col = 0; col < cols; col++) {
                int diff = countDiffAt(col, flippedArr, to);

                if (diff == 0) continue;    // col열에 있는 돌들이 모두 같을 경우 건너뛴다.
                if (diff == cols) count++;  // col열에 있는 돌들이 모두 다를 경우 뒤집는다.
                else {                      // 일부만 같을 경우 뒤집어도 똑같아서 이번턴 포기
                    count = Integer.MAX_VALUE;
                    break;
                }
            }

            answer = Math.min(answer, count);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // source와 target의 특정열(col)에 서로 다른 돌이 있을 때, 그 돌들의 개수
    private int countDiffAt(int col, int[] source, int[] target) {
        final int mask = 1 << col;
        return (int) IntStream.range(0, source.length)
                .filter(i -> (source[i] & mask) != (target[i] & mask))
                .count();
    }

    private int[] toBitMaskingArr(int[][] arr) {
        return Arrays.stream(arr)
                .map(row -> Arrays.toString(row).replaceAll("[^\\d]", ""))
                .mapToInt(row -> Integer.parseUnsignedInt(row, 2))
                .toArray();
    }
}
