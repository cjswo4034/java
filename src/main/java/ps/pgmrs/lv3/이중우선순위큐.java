package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 이중우선순위큐 implements Solution<int[]> {
    @Override
    public int[] solution(Object... params) {
        return solution((String[]) params);
    }

    // 최악의 경우 각각 50만번의 추가, 삭제 연산이 등장함
    // 삭제연산이 등장할 때마다 정렬 O(nlogn) -> 약 1000만번의 연산 필요 -> 가능
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for (String op : operations) {
            if (op.startsWith("I")) {
                list.add(Integer.parseInt(op.substring(2)));
            } else if (!list.isEmpty()) {
                Collections.sort(list);
                list.remove(op.indexOf('-') >= 0 ? 0 : list.size() - 1);
            }
        }

        Collections.sort(list);
        return toAnswer(list);
    }

    int[] toAnswer(List<Integer> list) {
        if (list.isEmpty())
            return new int[]{0, 0};

        int min = list.get(0);
        int max = list.size() == 1 ? list.get(0) : list.get(list.size() - 1);
        return new int[]{max, min};
    }

    public int[] solution2(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int[] answer = new int[]{0, 0};
        Integer value;
        for (String op: operations) {
            if (op.startsWith("I")) {
                value = Integer.parseInt(op.substring(2));
                max.add(value);
                min.add(value);
            } else if (min.size() > 0) {
                if (op.indexOf('-') >= 0) {
                    value = min.poll();
                    max.remove(value);
                } else {
                    value = max.poll();
                    min.remove(value);
                }
            }
        }

        if (min.size() > 0) {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }

        return answer;
    }
}
