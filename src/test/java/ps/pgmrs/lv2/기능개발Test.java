package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class 기능개발Test {
    private static final Solution<int[]> prob = new 기능개발();

    @Test
    void case1() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] expected = {2, 1};
        int[] actual = prob.solution(progresses, speeds);

        assertArrayEquals(expected, actual);
    }

    @Test
    void case2() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] expected = {1, 3, 2};
        int[] actual = prob.solution(progresses, speeds);

        assertArrayEquals(expected, actual);
    }
}