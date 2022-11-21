package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 고고학_최고의_발견Test {
    고고학_최고의_발견 sol;

    @BeforeEach
    void beforeEach() {
        sol = new 고고학_최고의_발견();
    }

    @Test
    void test1() {
        int[][] clockHands = TestUtil.strMatrixToIntMatrix("[" +
                "[0,3,3,0]," +
                "[3,2,2,3]," +
                "[0,3,2,0]," +
                "[0,3,3,3]]");
        int expect = 3;

        int actual = sol.solution(clockHands);

        assertEquals(expect, actual);
    }

    @Test
    void test2() {
        int[][] clockHands = TestUtil.strMatrixToIntMatrix("[" +
                "[3,0,3]," +
                "[1,0,1]," +
                "[0,1,0]");
        int expect = 4;

        int actual = sol.solution(clockHands);

        assertEquals(expect, actual);
    }

    void test3() {
        int[][] clockHands = TestUtil.strMatrixToIntMatrix("[" +
                "[0,3,3,0,0,3,3,0]," +
                "[3,2,2,3,3,2,2,3]," +
                "[0,3,3,0,0,3,3,0]," +
                "[0,0,0,0,0,0,0,0]," +
                "[0,3,3,0,0,3,3,0]," +
                "[3,2,2,3,3,2,2,3]," +
                "[0,3,3,0,0,3,3,0]," +
                "[0,0,0,0,0,0,0,0]");
        int expect = 8;

        int actual = sol.solution(clockHands);

        assertEquals(expect, actual);
    }
}