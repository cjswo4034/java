package ps.pgmrs.lv3;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        final int row = board.length;
        final int col = board[0].length;

        int[][] mergedSkill = merge(skill, row + 1, col + 1);

        accumulate(mergedSkill, row + 1, col + 1);

        return IntStream.range(0, row)
                .map(r -> countPositive(board[r], mergedSkill[r]))
                .sum();
    }

    private void accumulate(int[][] skills, int row, int col) {
        repeat(0, row, r -> repeat(1, col, c -> skills[r][c] += skills[r][c - 1]));
        repeat(0, col, c -> repeat(1, row, r -> skills[r][c] += skills[r - 1][c]));
    }

    private int[][] merge(int[][] skills, int row, int col) {
        int[][] res = new int[row][col];
        Arrays.stream(skills)
                .map(Skill::new)
                .forEach(skill -> {
                    res[skill.r1][skill.c1] += skill.degree;
                    res[skill.r1][skill.c2 + 1] -= skill.degree;
                    res[skill.r2 + 1][skill.c1] -= skill.degree;
                    res[skill.r2 + 1][skill.c2 + 1] += skill.degree;
                });
        return res;
    }

    private int countPositive(int[] rowA, int[] rowB) {
        return (int) IntStream.range(0, Math.min(rowA.length, rowB.length))
                .filter(i -> rowA[i] + rowB[i] > 0)
                .count();
    }

    private void repeat(int from, int to, Consumer<Integer> func) {
        for (int i = from; i < to; i++)
            func.accept(i);
    }

//    public int solution(int[][] board, int[][] skills) {
//        int[][] mergedSkill = merge(skills, board.length + 1, board[0].length + 1);
//
//        accumulate(mergedSkill);
//
//        merge(board, mergedSkill);
//
//        return (int) Arrays.stream(board)
//                .flatMapToInt(Arrays::stream)
//                .filter(e -> e > 0)
//                .count();
//    }
//
//    private int[][] merge(int[][] skills, int row, int col) {
//        int[][] result = new int[row][col];
//        Arrays.stream(skills)
//                .map(Skill::new)
//                .forEach(skill -> {
//                    result[skill.r1][skill.c1] += skill.degree;
//                    result[skill.r1][skill.c2 + 1] -= skill.degree;
//                    result[skill.r2 + 1][skill.c1] -= skill.degree;
//                    result[skill.r2 + 1][skill.c2 + 1] += skill.degree;
//                });
//        return result;
//    }
//
//    private void accumulate(int[][] acc) {
//        repeat.accept(0, acc.length, row ->
//                repeat.accept(1, acc[0].length, col -> acc[row][col] += acc[row][col - 1]));
//        repeat.accept(0, acc[0].length, col ->
//                repeat.accept(1, acc.length, row -> acc[row][col] += acc[row - 1][col]));
//    }
//
//    private void merge(int[][] board, int[][] accMatrix) {
//        repeat.accept(0, board.length, row ->
//                repeat.accept(0, board[0].length, col -> board[row][col] += accMatrix[row][col]));
//    }

    static class Skill {
        int r1, c1;
        int r2, c2;
        int degree;

        public Skill(int[] skill) {
            r1 = skill[1];
            c1 = skill[2];
            r2 = skill[3];
            c2 = skill[4];
            degree = skill[5] * (skill[0] == 1 ? -1 : 1);
        }
    }
}
