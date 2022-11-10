package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class 부대복귀Test {
    부대복귀 sol;

    @BeforeEach
    void beforeEach() {
        sol = new 부대복귀();
    }

    @Test
    void test1() {
        int n = 3;
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2, 3};
        int destination = 1;
        int[] expected = {1, 2};

        int[] actual = sol.solution(n, roads, sources, destination);

        assertArrayEquals(expected, actual);
    }
}