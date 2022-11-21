package ps.pgmrs.lv3;

import java.util.Arrays;

public class 숫자타자대회 {
    public int solution(String numbers) {
        int[][] weights = init();   // weights[i][j] = 키패드 i에서 j로 갈 때 가중치
        int[][] prev = newMatrix(); // prevDist[i][j] = 왼손과 오른손이 각각 i와 j에 있을 때 최소길이

        prev[4][6] = 0;

        for (char ch : numbers.toCharArray()) {
            prev = solve(weights, prev, Character.digit(ch, 10));
        }

        return Arrays.stream(prev)
                .mapToInt(row -> Arrays.stream(row).min().getAsInt())
                .min()
                .orElse(-1);
    }

    private int[][] solve(int[][] weights, int[][] prev, int number) {
        int[][] curr = newMatrix();
        for (int left = 0; left < 10; left++) {
            for (int right = 0; right < 10; right++) {
                if (prev[left][right] == Integer.MAX_VALUE) continue;

                int value = prev[left][right];
                if (left == number || right == number) {
                    curr[left][right] = Math.min(curr[left][right], value + 1);
                } else {
                    curr[left][number] = Math.min(curr[left][number], value + weights[right][number]);
                    curr[number][right] = Math.min(curr[number][right], value + weights[left][number]);
                }
            }
        }
        return curr;
    }

    private int[][] newMatrix() {
        int[][] matrix = new int[10][10];
        for (int[] row : matrix)
            Arrays.fill(row, Integer.MAX_VALUE);
        return matrix;
    }

    private int[][] init() {
        int[][] digits = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        int[][] dist = newMatrix();

        for (int i = 0; i < 10; i++) dist[i][i] = 0;

        fill(dist, digits, 0, 0);

        dist[1][0] = dist[0][1] = 7;
        dist[3][0] = dist[0][3] = 7;

        return dist;
    }

    private void fill(int[][] dist, int[][] digits, int row, int col) {
        if (row >= digits.length) return;
        if (col >= digits[0].length) {
            fill(dist, digits, row + 1, 0);
            return;
        }

        int from = digits[row][col];
        if (from != -1) {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 3; c++) {
                    int value;
                    int to = digits[r][c];
                    int diff = Math.abs(row - r) + Math.abs(col - c);

                    if (to == -1) continue;

                    if (r == row && c == col) value = 1;
                    else if (r == row || c == col) value = diff * 2;
                    else value = (diff / 2 * 3) + (diff % 2 * 2);

                    dist[from][to] = value;
                }
            }
        }

        fill(dist, digits, row, col + 1);
        if (from >= 0) dist[from][from] = 1;
    }
}
