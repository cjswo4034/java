package ps.pgmrs.lv1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class 모의고사Test {
    private Solution<int[]> prob;

    @BeforeEach
    void setUp() {
        prob = new 모의고사();
    }

    @Test
    void case1() {
        int[] answers = {1, 2, 3, 4, 5};
        int[] expected = {1};
        int[] actual = prob.solution(answers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void case2() {
        int[] answers = {1, 3, 2, 4, 2};
        int[] expected = {1, 2, 3};
        int[] actual = prob.solution(answers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void case3() {
        int[] answers = {1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2};
        int[] expected = {1};
        int[] actual = prob.solution(answers);

        assertArrayEquals(expected, actual);
    }
}