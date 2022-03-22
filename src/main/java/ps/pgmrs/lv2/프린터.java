package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int[]) params[0], (int) params[1]);
    }

    // 1. 맨 앞의 문서를 꺼낸다.
    // 2. 중요도가 높은 문서가 있다면 대기열 뒤에 넣는다.
    // 3. 중요도가 가장 높다면 인쇄한다.
    public int solution(int[] priorities, int location) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            Pair pair = new Pair(priorities[i], i);
            q.add(pair);
        }

        Arrays.sort(priorities);

        int step = 0;
        int index = priorities.length - 1;
        while (!q.isEmpty()) {
            Pair pair = q.poll();

            if (pair.priority != priorities[index]) {
                q.add(pair);
            } else if (location != pair.index) {
                index--;
                step++;
            } else {
                step++;
                break;
            }
        }

        return step;
    }

    class Pair {
        int priority;
        int index;

        public Pair(int priority, int i) {
            this.priority = priority;
            this.index = i;
        }
    }
}
