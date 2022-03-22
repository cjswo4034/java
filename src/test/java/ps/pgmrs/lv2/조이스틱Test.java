package ps.pgmrs.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 조이스틱Test {
    private Solution<Integer> prob;

    @BeforeEach
    void setup() {
        prob = new 조이스틱();
    }

    @Test
    void case1() {
        String name = "JEROEN";

        assertEquals(56, prob.solution(name));
    }

    @Test
    void case2() {
        String name = "JAN";

        assertEquals(23, prob.solution(name));
    }
}