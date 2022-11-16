package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 코딩_테스트_공부Test {
    코딩_테스트_공부 sol;

    @BeforeEach
    void before() {
        sol = new 코딩_테스트_공부();
    }

    @Test
    void test1() {
        int alp = 10;
        int cop = 10;
        int[][] problems = TestUtil.strMatrixToIntMatrix("[" +
                "[10,15,2,1,2]," +
                "[20,20,3,3,4]]");
        int expected = 15;

        int actual = sol.solution(alp, cop, problems);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int alp = 0;
        int cop = 0;
        int[][] problems = TestUtil.strMatrixToIntMatrix("[" +
                "[0,0,2,1,2]," +
                "[4,5,3,1,2]," +
                "[4,11,4,0,2]," +
                "[10,4,0,4,2]]");
        int expected = 13;

        int actual = sol.solution(alp, cop, problems);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int alp = 0;
        int cop = 0;
        int[][] problems = TestUtil.strMatrixToIntMatrix("[" +
                "[0, 0, 2, 1, 2], " +
                "[1, 1, 10, 10, 1], " +
                "[10, 10, 10, 10, 10]");
        int expected = 3;
        // 2초 (1, 1)
        // 3초 후, (11, 11)
        int actual = sol.solution(alp, cop, problems);

        assertEquals(expected, actual);
    }
}