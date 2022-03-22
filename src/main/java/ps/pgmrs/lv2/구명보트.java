package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.Arrays;

public class 구명보트 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int[]) params[0], (int) params[1]);
    }

    // - 몸무게가 가장 작은 사람들부터 최대한 많이 태운다. (반례: 1, 2, 4, 5, 8, 9)
    // - 합이 limit에 가장 가까운 사람들부터 태운다.
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }
}
