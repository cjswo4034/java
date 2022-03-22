package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 프린터Test {
    private static final Solution<Integer> prob = new 프린터();

    @Test
    void case1() {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int expected = 1;

        assertEquals(expected, prob.solution(priorities, location));
    }

    @Test
    void case2() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int expected = 5;

        assertEquals(expected, prob.solution(priorities, location));
    }
}