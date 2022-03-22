package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 타겟넘버Test {
    private static final Solution<Integer> prob = new 타겟넘버();

    @Test
    void case1() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        assertEquals(5, prob.solution(numbers, target));
    }
}