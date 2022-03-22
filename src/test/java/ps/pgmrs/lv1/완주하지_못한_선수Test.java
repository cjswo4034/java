package ps.pgmrs.lv1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 완주하지_못한_선수Test {
    private Solution<String> prob;

    @BeforeEach
    void setup() {
        prob = new 완주하지_못한_선수();
    }

    @Test
    void case1() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String expected = "leo";
        String actual = prob.solution(participant, completion);

        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        String expected = "vinko";
        String actual = prob.solution(participant, completion);

        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String expected = "mislav";
        String actual = prob.solution(participant, completion);

        assertEquals(expected, actual);
    }
}