package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class 기능개발 implements Solution<int[]> {
    @Override
    public int[] solution(Object... params) {
        return solution((int[]) params[0], (int[]) params[1]);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] needDays = calcNeedDays(progresses, speeds);

        int count = 1;
        int max = needDays[0];
        for (int i = 1; i < needDays.length; i++) {
            if (max < needDays[i]) {
                answer.add(count);
                max = needDays[i];
                count = 1;
            } else {
                count++;
            }
        }

        answer.add(count);
        return answer.stream().mapToInt(i -> i).toArray();
    }

    int[] calcNeedDays(int[] progresses, int[] speeds) {
        return IntStream.range(0, progresses.length)
                .map(i -> calcNeedDays(progresses[i], speeds[i]))
                .toArray();
    }

    int calcNeedDays(int progress, double speed) {
        return (int) Math.ceil((100 - progress) / speed);
    }
}
