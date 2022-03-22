package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 위장Test {
    private static final Solution<Integer> PROB = new 위장();

    @Test
    void case1() {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int expected= 5;

        assertEquals(expected, PROB.solution(clothes));
    }

    @Test
    void case2() {
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        int expected= 3;

        assertEquals(expected, PROB.solution(clothes));
    }
}