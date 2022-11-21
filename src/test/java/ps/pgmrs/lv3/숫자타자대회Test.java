package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 숫자타자대회Test {
    숫자타자대회 sol;

    @BeforeEach
    void before() {
        sol = new 숫자타자대회();
    }

    @Test
    void test1() {
        String numbers = "1756";
        int expected = 10;

        int actual = sol.solution(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String numbers = "5123";
        int expected = 8;

        int actual = sol.solution(numbers);

        assertEquals(expected, actual);
    }
}