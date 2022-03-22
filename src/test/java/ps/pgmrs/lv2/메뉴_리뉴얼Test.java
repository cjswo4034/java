package ps.pgmrs.lv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class 메뉴_리뉴얼Test {
    Solution<String[]> prob;

    @BeforeEach
    void setup() {
        prob = new 메뉴_리뉴얼();
    }

    @Test
    void case1() {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        String[] expected = {"AC", "ACDE", "BCFG", "CDE"};
        String[] actual = prob.solution(orders, course);

        assertArrayEquals(expected, actual);
    }

    @Test
    void case2() {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};

        String[] expected = {"ACD", "AD", "ADE", "CD", "XYZ"};
        String[] actual = prob.solution(orders, course);

        assertArrayEquals(expected, actual);
    }

    @Test
    void case3() {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        String[] expected = {"WX", "XY"};
        String[] actual = prob.solution(orders, course);

        assertArrayEquals(expected, actual);
    }
}