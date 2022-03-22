package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 구명보트Test {
    private static final Solution<Integer> prob = new 구명보트();

    @Test
    void case1() {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        assertEquals(3, prob.solution(people, limit));
    }

    @Test
    void case2() {
        int[] people = {70, 80, 50};
        int limit = 100;

        assertEquals(3, prob.solution(people, limit));
    }

    @Test
    void case3() {
        int[] people = {1, 2, 4, 5, 8, 9};
        int limit = 10;

        assertEquals(3, prob.solution(people, limit));
    }

    @Test
    void case4() {
        int[] people = {1, 1, 8};
        int limit = 10;

        assertEquals(2, prob.solution(people, limit));
    }
}