package ps.pgmrs.lv3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 표_편집Test {
    표_편집 sol;

    @BeforeEach
    void beforeEach() {
        sol = new 표_편집();
    }

    @Test
    void test1() {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String expected = "OOOOXOOO";

        String actual = sol.solution(n, k, cmd);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        String expected = "OOXOXOOO";

        String actual = sol.solution(n, k, cmd);

        assertEquals(expected, actual);
    }

    @Test
    void stressTest() {
        int n = 1000000;
        int k = 0;
        String[] cmd = ("C".repeat(100000) + "Z".repeat(100000)).split("");

        String actual = sol.solution(n, k, cmd);
    }
}