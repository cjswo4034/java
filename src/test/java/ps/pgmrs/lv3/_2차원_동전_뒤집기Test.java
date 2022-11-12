package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.TestUtil.strMatrixToIntMatrix;

class _2차원_동전_뒤집기Test {
    private _2차원_동전_뒤집기 sol;

    @BeforeEach
    void beforeEach() {
        sol = new _2차원_동전_뒤집기();
    }

    @Test
    void test1() {
        String strBeginning = "[[0, 1, 0, 0, 0], [1, 0, 1, 0, 1], [0, 1, 1, 1, 0], [1, 0, 1, 1, 0], [0, 1, 0, 1, 0]]";
        String strTarget = "[[0, 0, 0, 1, 1], [0, 0, 0, 0, 1], [0, 0, 1, 0, 1], [0, 0, 0, 1, 0], [0, 0, 0, 0, 1]]";
        int[][] beginning = strMatrixToIntMatrix(strBeginning);
        int[][] target = strMatrixToIntMatrix(strTarget);

        int expect = 5;
        int actual = sol.solution(beginning, target);

        assertEquals(expect, actual);
    }

    @Test
    void test2() {
        String strBeginning = "[[0, 0, 0], [0, 0, 0], [0, 0, 0]]";
        String strTarget = "[[1, 0, 1], [0, 0, 0], [0, 0, 0]]";
        int[][] beginning = strMatrixToIntMatrix(strBeginning);
        int[][] target = strMatrixToIntMatrix(strTarget);

        int expect = -1;
        int actual = sol.solution(beginning, target);

        assertEquals(expect, actual);
    }

    @Test
    void test3() {
        String strBeginning = "[[0, 0, 0], [0, 0, 0], [0, 0, 0]]";
        String strTarget = "[[0, 0, 0], [0, 0, 0], [0, 0, 0]]";
        int[][] beginning = strMatrixToIntMatrix(strBeginning);
        int[][] target = strMatrixToIntMatrix(strTarget);

        int expect = 0;
        int actual = sol.solution(beginning, target);

        assertEquals(expect, actual);
    }
}