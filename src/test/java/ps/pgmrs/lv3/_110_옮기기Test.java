package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class _110_옮기기Test {
    _110_옮기기 sol;

    @BeforeEach
    void beforeEach() {
        sol = new _110_옮기기();
    }

    @Test
    void test1() {
        String[] s = {"1110", "100111100", "0111111010", "1100111011101001"};
        String[] expected = {"1101", "100110110", "0110110111", "0101101101101101"};

        String[] actual = sol.solution(s);

        assertArrayEquals(expected, actual);
    }
}