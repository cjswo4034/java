package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 등산코스_정하기Test {
    등산코스_정하기 sol;

    @BeforeEach
    void before() {
        sol = new 등산코스_정하기();
    }

    @Test
    void test1() {
        int n = 6;
        int[][] paths = TestUtil.strMatrixToIntMatrix("[[1, 2, 3], [2, 3, 5], [2, 4, 2], [2, 5, 4], [3, 4, 4], [4, 5, 3], [4, 6, 1], [5, 6, 1]]");
        int[] gates = {1, 3};
        int[] summits = {5};

        int[] expected = {5, 3};
        int[] actual = sol.solution(n, paths, gates, summits);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void test2() {
        int n = 7;
        int[][] paths = TestUtil.strMatrixToIntMatrix("[[1, 4, 4], [1, 6, 1], [1, 7, 3], [2, 5, 2], [3, 7, 4], [5, 6, 6]]");
        int[] gates = {1};
        int[] summits = {2, 3, 4};

        int[] expected = {3, 4};
        int[] actual = sol.solution(n, paths, gates, summits);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void test3() {
        int n = 7;
        int[][] paths = TestUtil.strMatrixToIntMatrix("[[1, 2, 5], [1, 4, 1], [2, 3, 1], [2, 6, 7], [4, 5, 1], [5, 6, 1], [6, 7, 1]]");
        int[] gates = {3, 7};
        int[] summits = {1, 5};

        int[] expected = {5, 1};
        int[] actual = sol.solution(n, paths, gates, summits);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void test4() {
        int n = 5;
        int[][] paths = TestUtil.strMatrixToIntMatrix("[[1, 3, 10], [1, 4, 20], [2, 3, 4], [2, 4, 6], [3, 5, 20], [4, 5, 6]]");
        int[] gates = {1, 2};
        int[] summits = {5};

        int[] expected = {5, 6};
        int[] actual = sol.solution(n, paths, gates, summits);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void test5() {
        int n = 7;
        int[][] paths = TestUtil.strMatrixToIntMatrix("[[1, 4, 4], [1, 6, 1], [1, 7, 3], [2, 5, 2], [3, 7, 4], [5, 6, 6]]");
        int[] gates = {2};
        int[] summits = {3, 4};

        int[] expected = {3, 6};
        int[] actual = sol.solution(n, paths, gates, summits);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }
}