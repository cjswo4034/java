package ps.pgmrs.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class 우박수열_정적분Test {
    우박수열_정적분 sol = new 우박수열_정적분();

    @BeforeEach
    void before() {
        sol = new 우박수열_정적분();
    }

    @Test
    void test1() {
        int k = 5;
        int[][] ranges = TestUtil.strMatrixToIntMatrix("[[0,0],[0,-1],[2,-3],[3,-3]]");
        double[] expected = {33.0, 31.5, 0.0, -1.0};

        double[] actual = sol.solution(k, ranges);

        assertArrayEquals(expected, actual);
    }
}