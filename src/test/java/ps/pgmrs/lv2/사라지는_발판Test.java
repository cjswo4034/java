package ps.pgmrs.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 사라지는_발판Test {
    사라지는_발판 sol;

    @BeforeEach
    void before() {
        sol = new 사라지는_발판();
    }

    @Test
    void test1() {
        int[][] board = TestUtil.strMatrixToIntMatrix("[[1, 1, 1], [1, 1, 1], [1, 1, 1]]");
        int[] aloc = {1, 0};
        int[] bloc = {1, 2};
        int expected = 5;

        int actual = sol.solution(board, aloc, bloc);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[][] board = TestUtil.strMatrixToIntMatrix("[[1, 1, 1], [1, 0, 1], [1, 1, 1]]");
        int[] aloc = {1, 0};
        int[] bloc = {1, 2};
        int expected = 4;

        int actual = sol.solution(board, aloc, bloc);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[][] board = TestUtil.strMatrixToIntMatrix("[[1, 1, 1, 1, 1]]");
        int[] aloc = {0, 0};
        int[] bloc = {0, 4};
        int expected = 4;

        int actual = sol.solution(board, aloc, bloc);

        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int[][] board = TestUtil.strMatrixToIntMatrix("[[1]]");
        int[] aloc = {0, 0};
        int[] bloc = {0, 0};
        int expected = 0;

        int actual = sol.solution(board, aloc, bloc);

        assertEquals(expected, actual);
    }
}