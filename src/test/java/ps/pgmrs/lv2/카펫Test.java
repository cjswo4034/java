package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class 카펫Test {
    private static final Solution<int[]> prob = new 카펫();

    @Test
    void case1() {
        int brown = 10;
        int yellow = 2;

        int[] expected = {4, 3};
        int[] actual = prob.solution(brown, yellow);

        assertArrayEquals(expected, actual);
    }

    @Test
    void case2() {
        int brown = 8;
        int yellow = 1;

        int[] expected = {3, 3};
        int[] actual = prob.solution(brown, yellow);

        assertArrayEquals(expected, actual);
    }

    @Test
    void case3() {
        int brown = 24;
        int yellow = 24;

        int[] expected = {8, 6};
        int[] actual = prob.solution(brown, yellow);

        assertArrayEquals(expected, actual);
    }
}