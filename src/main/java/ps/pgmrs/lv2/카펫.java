package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

public class 카펫 implements Solution<int[]> {
    @Override
    public int[] solution(Object... params) {
        return solution((int) params[0], (int) params[1]);
    }

    public int[] solution(int brown, int yellow) {
        for (int col = 1; col < brown; col++) {
            int row = (brown - (2 * col)) / 2 + 2;
            if (row > col || row <= 0) continue;

            int bb = col * 2 + (row - 2) * 2;
            int yy = (col - 2) * (row - 2);

            if (bb == brown && yy == yellow)
                return new int[]{col, row};
        }
        throw new IllegalArgumentException();
    }
}
