package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 양과_늑대Test {
    양과_늑대 sol;

    @BeforeEach
    void test() {
        sol = new 양과_늑대();
    }

    @Test
    void test1() {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = TestUtil.strMatrixToIntMatrix("[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]");
        int expected = 5;

        int actual = sol.solution(info, edges);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] info = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
        int[][] edges = TestUtil.strMatrixToIntMatrix("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]");
        int expected = 5;

        int actual = sol.solution(info, edges);

        assertEquals(expected, actual);
    }
}