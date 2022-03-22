package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.*;

class H_IndexTest {
    private static final Solution<Integer> prob = new H_Index();

    @Test
    void case1() {
        int[] citations = {3, 0, 6, 1, 5};

        assertEquals(3, prob.solution(citations));
    }

    @Test
    void case2() {
        int[] citations = {3, 1, 6, 5, 1, 1};

        assertEquals(1, prob.solution(citations));
    }

    @Test
    void case3() {
        int[] citations = {0, 0, 0};

        assertEquals(0, prob.solution(citations));
    }
}