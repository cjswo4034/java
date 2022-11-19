package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 아이템_줍기Test {
    아이템_줍기 sol;

    @BeforeEach
    void before() {
        sol = new 아이템_줍기();
    }

    @Test
    void test1() {
        int[][] rectangle = TestUtil.strMatrixToIntMatrix("[[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]");
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        int expected = 17;
        int actual = sol.solution(rectangle, characterX, characterY, itemX, itemY);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[][] rectangle = TestUtil.strMatrixToIntMatrix("[[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]]");
        int characterX = 9;
        int characterY = 7;
        int itemX = 6;
        int itemY = 1;

        int expected = 11;
        int actual = sol.solution(rectangle, characterX, characterY, itemX, itemY);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[][] rectangle = TestUtil.strMatrixToIntMatrix("[[1,1,5,7]]");
        int characterX = 1;
        int characterY = 1;
        int itemX = 4;
        int itemY = 7;

        int expected = 9;
        int actual = sol.solution(rectangle, characterX, characterY, itemX, itemY);

        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        int[][] rectangle = TestUtil.strMatrixToIntMatrix("[[2,1,7,5],[6,4,10,10]]");
        int characterX = 3;
        int characterY = 1;
        int itemX = 7;
        int itemY = 10;

        int expected = 15;
        int actual = sol.solution(rectangle, characterX, characterY, itemX, itemY);

        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        int[][] rectangle = TestUtil.strMatrixToIntMatrix("[[2,2,5,5],[1,3,6,4],[3,1,4,6]]");
        int characterX = 1;
        int characterY = 4;
        int itemX = 6;
        int itemY = 3;

        int expected = 10;
        int actual = sol.solution(rectangle, characterX, characterY, itemX, itemY);

        assertEquals(expected, actual);
    }
}