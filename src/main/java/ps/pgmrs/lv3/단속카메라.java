package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int[][]) params);
    }

    public int solution(int[][] routes) {
        // [0] < [1] 이라고 가정.
        Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));
        int answer = 0;
        for (int i = 0, j = 1, len = routes.length; i < len; i++) {
            while (j < len && routes[j][0] <= routes[i][1]) {
                j++;
            }
            i = j - 1;
            answer++;
        }

        return answer;
    }
}
