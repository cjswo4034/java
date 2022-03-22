package ps.pgmrs.lv4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class 가사검색Test {
    Solution<int[]> prob;

    @BeforeEach
    void setup() {
        prob = new 가사검색();
    }

    @Test
    void case1() {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "frozen?"};

        int[] expected = {3, 2, 4, 1, 0};
        int[] actual = prob.solution(words, queries);

        assertArrayEquals(expected, actual);
    }
}