package ps.pgmrs.lv1;

import ps.pgmrs.Solution;

import java.util.Arrays;

public class K번째수 implements Solution<int[]> {
    @Override
    public int[] solution(Object... params) {
        return solution((int[]) params[0], (int[][]) params[1]);
    }

    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(cmd -> solution(array, cmd))
                .toArray();
    }

    int solution(int[] array, int[] cmd) {
        return Arrays.stream(Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]))
                .sorted()
                .toArray()[cmd[2] - 1];
    }
}
