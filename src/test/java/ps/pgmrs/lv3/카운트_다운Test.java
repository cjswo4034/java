package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 카운트_다운Test {
    카운트_다운 sol;

    @BeforeEach
    void beforeEach() {
        sol = new 카운트_다운();
    }

    @Test
    void test1() {
        int target = 29;
        int[] expected = {2, 2};

        int[] actual = sol.solution(target);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void test2() {
        int target = 58;
        int[] expected = {2, 2};

        int[] actual = sol.solution(target);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void test3() {
        int target = 100000;
        int[] expected = {1667, 2};

        int[] actual = sol.solution(target);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }
}