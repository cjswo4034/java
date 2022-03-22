package ps.pgmrs.lv1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 신규아이디_추천Test {
    Solution<String> prob;

    @BeforeEach
    void setup() {
        prob = new 신규아이디_추천();
    }

    @Test
    void case1() {
        String newId = "...!@BaT#*..y.abcdefghijklm";

        String expected = "bat.y.abcdefghi";
        String actual = prob.solution(newId);

        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        String newId = "z-+.^.";

        String expected = "z--";
        String actual = prob.solution(newId);

        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        String newId = "=.=";

        String expected = "aaa";
        String actual = prob.solution(newId);

        assertEquals(expected, actual);
    }

    @Test
    void case4() {
        String newId = "123_.def";

        String expected = "123_.def";
        String actual = prob.solution(newId);

        assertEquals(expected, actual);
    }

    @Test
    void case5() {
        String newId = "abcdefghijklmn.p";

        String expected = "abcdefghijklmn";
        String actual = prob.solution(newId);

        assertEquals(expected, actual);
    }
}