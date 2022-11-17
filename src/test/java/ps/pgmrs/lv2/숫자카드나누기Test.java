package ps.pgmrs.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 숫자카드나누기Test {
    숫자카드나누기 sol;

    @BeforeEach
    void before() {
        sol = new 숫자카드나누기();
    }

    @Test
    void test1() {
        int[] a = {10, 17};
        int[] b = {5, 20};
        int expected = 0;

        int actual = sol.solution(a, b);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] a = {10, 20};
        int[] b = {5, 17};
        int expected = 10;

        int actual = sol.solution(a, b);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] a = {14, 35, 119};
        int[] b = {18, 30, 102};
        int expected = 7;

        int actual = sol.solution(a, b);

        assertEquals(expected, actual);
    }
}