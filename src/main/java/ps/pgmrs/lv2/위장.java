package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 위장 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((String[][]) params);
    }

    public Integer solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(Collectors.groupingBy(cloth -> cloth[1], Collectors.counting()))
                .values().stream()
                .reduce(1L, (acc, cur) -> acc * (cur + 1))
                .intValue() - 1;
    }
}
