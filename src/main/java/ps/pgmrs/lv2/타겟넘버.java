package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

public class 타겟넘버 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int[]) params[0], (int) params[1]);
    }

    int target = 0;

    public int solution(int[] numbers, int target) {
        this.target = target;
        return dfs(numbers, 0, 0);
    }

    int dfs(int[] numbers, int depth, int sum) {
        if (numbers.length <= depth) {
            return sum == target ? 1 : 0;
        }

        return dfs(numbers, depth + 1, sum + numbers[depth]) +
                dfs(numbers, depth + 1, sum - numbers[depth]);
    }
}
