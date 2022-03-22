package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class 가장_큰_수Test {
    private static final Solution<String> prob = new 가장_큰_수();

    @Test
    void case1() {
        int[] numbers = {6, 10, 2, 5};

        String expected = "65210";
        String actual = prob.solution(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        int[] numbers = {3, 30, 34, 5, 9};

        String expected = "9534330";
        String actual = prob.solution(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        int[] numbers1 = {988, 98};
        int[] numbers2 = {98, 989};
        int[] numbers3 = {98, 9889};
        int[] numbers4 = {12, 1213};
        int[] numbers5 = {0, 0, 0, 0};
        System.out.println(Arrays.toString(numbers1) + "\t\t: " + prob.solution(numbers1));
        System.out.println(Arrays.toString(numbers2) + "\t\t: " + prob.solution(numbers2));
        System.out.println(Arrays.toString(numbers3) + "\t\t: " + prob.solution(numbers3));
        System.out.println(Arrays.toString(numbers4) + "\t\t: " + prob.solution(numbers4));
        System.out.println(Arrays.toString(numbers5) + "\t: " + prob.solution(numbers5));
    }
}