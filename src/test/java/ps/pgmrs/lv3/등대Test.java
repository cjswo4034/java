package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 등대Test {
    등대 sol;

    @BeforeEach
    void setup() {
        sol = new 등대();
    }

    @Test
    void test1() {
        int n = 8;
        int[][] lightHouse = new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};

        int expected = 2;
        int actual = sol.solution(n, lightHouse);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int n = 10;
        int[][] lightHouse = new int[][]{{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};

        int expected = 3;
        int actual = sol.solution(n, lightHouse);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int n = 6;
        int[][] lightHouse = new int[][]{{1, 2}, {2, 3}, {3, 4}, {3, 5}, {3, 6}};

        int expected = 2;
        int actual = sol.solution(n, lightHouse);

        assertEquals(expected, actual);
    }
}