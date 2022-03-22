package ps.pgmrs.lv1;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class K번째수Test {
    private static final Solution<int[]> prob = new K번째수();

    @Test
    void case1() {
        int[][] cmds = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[] expected = {5, 6, 3};

        assertArrayEquals(expected, prob.solution(array, cmds));
    }
}