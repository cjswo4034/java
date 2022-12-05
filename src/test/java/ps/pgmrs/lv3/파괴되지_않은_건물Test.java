package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 파괴되지_않은_건물Test {
    파괴되지_않은_건물 sol;

    @BeforeEach
    void before() {
        sol = new 파괴되지_않은_건물();
    }

    @Test
    void test1() {
        int[][] board = TestUtil.strMatrixToIntMatrix("[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]");
        int[][] skill = TestUtil.strMatrixToIntMatrix("[" +
                "[1,0,0,3,4,4]," +
                "[1,2,0,2,3,2]," +
                "[2,1,0,3,1,2]," +
                "[1,0,1,3,3,1]]");
        int expected = 10;

        int actual = sol.solution(board, skill);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[][] board = TestUtil.strMatrixToIntMatrix("[[1,2,3],[4,5,6],[7,8,9]]");
        int[][] skill = TestUtil.strMatrixToIntMatrix("[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]");
        int expected = 6;

        int actual = sol.solution(board, skill);

        assertEquals(expected, actual);
    }
}