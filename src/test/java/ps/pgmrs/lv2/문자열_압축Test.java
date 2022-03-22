package ps.pgmrs.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 문자열_압축Test {
    Solution<Integer> prob;

    @BeforeEach
    void setup() {
        prob = new 문자열_압축();
    }

    @Test
    void case1() {
        String s = "aabbaccc";

        Integer expected = 7;
        Integer actual = prob.solution(s);

        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        String s = "ababcdcdababcdcd";

        Integer expected = 9;
        Integer actual = prob.solution(s);

        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        String s = "abcabcdede";

        Integer expected = 8;
        Integer actual = prob.solution(s);

        assertEquals(expected, actual);
    }

    @Test
    void case4() {
        String s = "abcabcabcabcdededededede";

        Integer expected = 14;
        Integer actual = prob.solution(s);

        assertEquals(expected, actual);
    }

    @Test
    void case5() {
        String s = "xababcdcdababcdcd";

        Integer expected = 17;
        Integer actual = prob.solution(s);

        assertEquals(expected, actual);
    }

}