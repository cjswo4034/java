package ps.pgmrs.lv3;

import java.util.Arrays;

public class 아이템_줍기 {
    private static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private static final int MAX_LENGTH = 102;
    private boolean[][] isInRect;
    private int[][] dists;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 맵을 두배로 늘리기
        dists = initMap(rectangle);

        dfs(new Point(characterY * 2, characterX * 2), new Point(itemY * 2, itemX * 2), 0);

        return dists[itemY * 2][itemX * 2] >> 1;
    }

    private void dfs(Point ch, Point item, int dist) {
        if (ch.equals(item)) {
            dists[item.row][item.col] = Math.min(dists[item.row][item.col], dist);
            return;
        }
        if (dists[ch.row][ch.col] <= dist) return;

        dists[ch.row][ch.col] = dist;
        for (int i = 0; i < 4; i++) {
            int nRow = ch.row + DIRECTION[i][0];
            int nCol = ch.col + DIRECTION[i][1];
            Point next = new Point(nRow, nCol);

            if (!isInRect[nRow][nCol] || !verify(next)) continue;

            dfs(next, item, dist + 1);
        }
    }

    private boolean verify(Point next) {
        return Arrays.stream(DIRECTION)
                .anyMatch(dir -> !isInRect[next.row + dir[0]][next.col + dir[1]]);
    }

    private int[][] initMap(int[][] rectangle) {
        isInRect = new boolean[MAX_LENGTH][MAX_LENGTH];
        dists = new int[MAX_LENGTH][MAX_LENGTH];
        for (int[] dist : dists) Arrays.fill(dist, -1);
        for (int[] rect : rectangle) fill(rect);
        return dists;
    }

    private void fill(int[] rect) {
        for (int row = rect[1] * 2, rowLen = rect[3] * 2; row <= rowLen; row++) {
            for (int col = rect[0] * 2, colLen = rect[2] * 2; col <= colLen; col++) {
                isInRect[row][col] = true;
                dists[row][col] = Integer.MAX_VALUE;
            }
        }
    }

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return row == point.row && col == point.col;
        }
    }
}
