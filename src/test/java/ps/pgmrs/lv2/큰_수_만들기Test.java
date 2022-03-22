package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 큰_수_만들기Test {
    private static final Solution<String> prob = new 큰_수_만들기();

    @Test
    void case1() {
        String number = "1924";
        int k = 2;

        assertEquals("94", prob.solution(number, k));
    }

    @Test
    void case2() {
        String number = "1231234";
        int k = 3;

        assertEquals("3234", prob.solution(number, k));
    }

    @Test
    void case3() {
        String number = "4177252841";
        int k = 4;

        assertEquals("775841", prob.solution(number, k));
    }
}