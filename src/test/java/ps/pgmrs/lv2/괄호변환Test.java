package ps.pgmrs.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 괄호변환Test {
    Solution<String> prob;

    @BeforeEach
    void setup() {
        prob = new 괄호변환();
    }

    @Test
    void case1() {
        String p = "(()())()";

        String expected = "(()())()";
        String actual = prob.solution(p);

        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        String p = ")(";

        String expected = "()";
        String actual = prob.solution(p);

        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        String p = "()))((()";

        String expected = "()(())()";
        String actual = prob.solution(p);

        assertEquals(expected, actual);
    }

    @Test
    void case4() {
        String p = "()";

        String expected = "()";
        String actual = prob.solution(p);

        assertEquals(expected, actual);
    }

    @Test
    void case5() {
        String p = ")(";

        String expected = "()";
        String actual = prob.solution(p);

        assertEquals(expected, actual);
    }
}