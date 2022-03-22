package ps.pgmrs.lv2;

import org.junit.jupiter.api.Test;
import ps.pgmrs.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 다리를_지나는_트럭Test {
    private static final Solution<Integer> prob = new 다리를_지나는_트럭();

    @Test
    void case1() {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = {7, 4, 5, 6};

        int expected = 8;
        int actual = prob.solution(bridgeLength, weight, truckWeights);

        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = {10};

        int expected = 101;
        int actual = prob.solution(bridgeLength, weight, truckWeights);

        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        int expected = 110;
        int actual = prob.solution(bridgeLength, weight, truckWeights);

        assertEquals(expected, actual);
    }
}