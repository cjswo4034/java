package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.ArrayList;
import java.util.List;

public class 기둥과_보_설치 implements Solution<int[][]> {
    @Override
    public int[][] solution(Object... params) {
        return solution((int) params[0], (int[][]) params[1]);
    }

    public int[][] solution(int n, int[][] buildFrame) {
        boolean[][] pilar = new boolean[n + 1][n + 1];
        boolean[][] frame = new boolean[n + 1][n + 1];

        for (int[] b : buildFrame) {
            Build build = new Build(b);

            set(pilar, frame, build);

            verify(pilar, frame, build);
        }

        return getAnswer(pilar, frame, n + 1);
    }

    int[][] getAnswer(boolean[][] pilar, boolean[][] frame, int n) {
        List<Point> ans = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (frame[row][col]) {
                    ans.add(new Point(row, col, true));
                }
                if (pilar[row][col]) {
                    ans.add(new Point(row, col, false));
                }
            }
        }
        return ans.stream()
                .sorted()
                .map(Point::toArr)
                .toArray(int[][]::new);
    }

    void verify(boolean[][] pilar, boolean[][] frame, Build build) {
        if (!verify(pilar, frame)) {
            build.isSet ^= true;
            set(pilar, frame, build);
        }
    }

    boolean verify(boolean[][] pilar, boolean[][] frame) {
        for (int i = 0; i < pilar.length; i++) {
            for (int j = 0; j < frame.length; j++) {
                if (pilar[i][j] && !verifyPilar(pilar, frame, i, j)) return false;
                if (frame[i][j] && !verifyFrame(pilar, frame, i, j)) return false;
            }
        }
        return true;
    }

    boolean verifyPilar(boolean[][] pilar, boolean[][] frame, int x, int y) {
        if (x == 0) return true;
        if (frame[x][y]) return true;
        if (pilar[x - 1][y]) return true;
        return y > 0 && frame[x][y - 1];
    }

    boolean verifyFrame(boolean[][] pilar, boolean[][] frame, int x, int y) {
        if (pilar[x - 1][y]) return true;
        if (pilar[x - 1][y + 1]) return true;
        return y > 0 && frame[x][y + 1] && frame[x][y - 1];
    }

    void set(boolean[][] pilar, boolean[][] frame, Build build) {
        if (build.isPilar) {
            pilar[build.row][build.col] = build.isSet;
        } else {
            frame[build.row][build.col] = build.isSet;
        }
    }

    class Build {
        int row, col;
        boolean isPilar, isSet;

        public Build(int[] build) {
            row = build[1];
            col = build[0];
            isPilar = build[2] == 0;
            isSet = build[3] == 1;
        }

        @Override
        public String toString() {
            return "Build{" +
                    "row=" + row +
                    ", col=" + col +
                    ", isPilar=" + isPilar +
                    ", isSet=" + isSet +
                    '}';
        }
    }

    class Point implements Comparable<Point> {
        int row, col;
        boolean isFrame;

        public Point(int row, int y, boolean isFrame) {
            this.row = row;
            this.col = y;
            this.isFrame = isFrame;
        }

        public int[] toArr() {
            return new int[]{col, row, isFrame ? 1 : 0};
        }

        @Override
        public int compareTo(Point o) {
            if (col != o.col)
                return Integer.compare(col, o.col);
            if (row != o.row)
                return Integer.compare(row, o.row);
            return Boolean.compare(isFrame, o.isFrame);
        }
    }
}
