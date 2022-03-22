package ps.pgmrs.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 소수찾기Test {
    private Solution<Integer> prob;

    @BeforeEach
    void setup() {
        prob = new 소수찾기();
    }

    @Test
    void case1() {
        String numbers = "17";
        int expected = 3;
        int actual = prob.solution(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        String numbers = "011";
        int expected = 2;
        int actual = prob.solution(numbers);

        assertEquals(expected, actual);
    }
}