package ps.pgmrs.lv1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 체육복Test {
    private Solution<Integer> prob;

    @BeforeEach
    void setUp() {
        prob = new 체육복();
    }

    @Test
    void case1() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int actual = prob.solution(n, lost, reserve);
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        int actual = prob.solution(n, lost, reserve);
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        int actual = prob.solution(n, lost, reserve);
        int expected = 2;

        assertEquals(expected, actual);
    }
}