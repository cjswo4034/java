package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class H_Index implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int[]) params[0]);
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        return IntStream.rangeClosed(0, citations[citations.length - 1])
                .filter(hIndex -> isHIndex(citations, hIndex))
                .max().orElse(0);
    }

    // h번 이상 인용된 논문이 h개 이상이고
    // h번 이하 인용된 논문이 h개 이하일 때
    boolean isHIndex(int[] citations, int hIndex) {
        int over = 0;
        int under = 0;
        for (int citation: citations) {
            if (citation >= hIndex) over++;
            if (citation <= hIndex) under++;
        }
        return hIndex >= under && hIndex <= over;
    }
}
