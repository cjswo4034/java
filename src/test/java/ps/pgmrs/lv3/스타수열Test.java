package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 스타수열Test {
    스타수열 sol;

    @BeforeEach
    void before() {
        sol = new 스타수열();
    }

    @Test
    void test1() {
        int length = 500000;
        Random rand = new Random();
        int[] a = IntStream.rangeClosed(0, length)
                .map(i -> rand.nextInt(length))
                .toArray();

        int actual = getActualAndPrintTime(sol::solution, a);
        int actual2 = getActualAndPrintTime(sol::solution2, a);

        assertEquals(actual, actual2);
    }

    private int getActualAndPrintTime(Function<int[], Integer> func, int[] a) {
        long tic = System.currentTimeMillis();
        int res = func.apply(a);
        System.out.println(System.currentTimeMillis() - tic);
        return res;
    }

    @Test
    void test2() {
        int[] a = {5, 2, 3, 3, 5, 3};
        int expected = 4;

        int actual = sol.solution(a);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int[] a = {0, 3, 3, 0, 7, 2, 0, 2, 2, 0};
        int expected = 8;

        int actual = sol.solution(a);

        assertEquals(expected, actual);
    }
}