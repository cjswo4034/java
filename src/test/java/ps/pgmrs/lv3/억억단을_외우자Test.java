package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class 억억단을_외우자Test {
    억억단을_외우자 sol;

    @BeforeEach
    void beforeEach() {
        sol = new 억억단을_외우자();
    }

    @Test
    void test1() {
        int e = 8;
        int[] starts = {1, 3, 7};
        int[] expected = {6, 6, 8};

        int[] actual = sol.solution(e, starts);
        int[] refact = sol.refact(e, starts);

        assertArrayEquals(expected, actual);
        assertArrayEquals(actual, refact);
    }

    @Test
    void test2() {
        int e = 5000000;
        int[] starts = {1, 3, 7};
        int[] expected = {6, 6, 8};

        int[] actual = sol.solution(e, starts);

        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
}