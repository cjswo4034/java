package ps.pgmrs.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;
import ps.pgmrs.lv3.순위_검색;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class 순위_검색Test {
    Solution<int[]> prob;

    @BeforeEach
    void setup() {
        prob = new 순위_검색();
    }

    @Test
    void case1() {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"- and - and - and - 270", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        int[] expected = {0,1,1,1,2,4};
        int[] actual = prob.solution(info, query);

        assertArrayEquals(expected, actual);
    }
}