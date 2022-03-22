package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BinaryOperator;

public class N으로_표현 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int) params[0], (int) params[1]);
    }

    public int solution(int N, int number) {
        int answer = dfs(N, number, 0, 0);
        return answer > 8 ? -1 : answer;
//        return dp(N, number);
    }

    // XXX Case 4.
    private int dfs(int n, int number, int total, int count) {
        if (count > 8) return Integer.MAX_VALUE;
        if (total == number) return count;

        int nn = n;
        int result = Integer.MAX_VALUE;
        for (int next = count + 1, len = 9; next < len; next++) {
            result = Math.min(result, dfs(n, number, total + nn, next));
            result = Math.min(result, dfs(n, number, total - nn, next));
            result = Math.min(result, dfs(n, number, total * nn, next));
            result = Math.min(result, dfs(n, number, total / nn, next));
            result = Math.min(result, dfs(n, number, nn * total, next));
            if (total > 0) result = Math.min(result, dfs(n, number, nn / total, next));

            nn = nn * 10 + n;
        }

        return result;
    }

    /////////////////////////////////////////////////

    int bruteForce(int n, int number) {
        int answer = -1;
        Set<Integer>[] sets = new Set[9];
        for (int i = 1, nn = n; i < 9; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(nn);
            nn = nn * 10 + n;
        }

        for (int l = 1; l < 9; l++) {
            for (int r = 1; r <= l / 2; r++) {
                add(sets, l, r);
            }
        }

        for (int i = 1; i < 9; i++) {
            if (sets[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    void add(Set<Integer>[] sets, int l, int r) {
        for (Integer x : sets[r]) {
            for (Integer y : sets[l - r]) {
                sets[l].add(x + y);
                sets[l].add(x - y);
                sets[l].add(x * y);
                sets[l].add(y * x);
                if (x != 0) sets[l].add(y / x);
                if (y != 0) sets[l].add(x / y);
            }
        }
    }

    /////////////////////////////////////////////////////////

    public int solution2(int N, int number) {
        HashMap<Integer, Set<Integer>> valueStore = new HashMap<>();
        if (N == number)
            return 1;

        for (int i = 1; i <= 8; i++) {
            Set<Integer> iSet = new HashSet<>();

            int NNN = Integer.parseInt(Integer.toBinaryString((int) Math.pow(2, i) - 1)) * N;

            if (NNN == number)
                return i;
            else
                iSet.add(NNN);

            for (int j = 1; j <= i / 2; j++) {
                for (Integer a : valueStore.get(j)) {
                    for (Integer b : valueStore.get(i - j)) {
                        int opResult = 0;
                        for (Operation o : Operation.values()) {
                            opResult = o.calc(a, b);
                            if (opResult == number)
                                return i;
                            else
                                iSet.add(opResult);
                        }
                    }
                }
            }
            valueStore.put(i, iSet);
        }
        return -1;
    }

    enum Operation {
        ADD((a, b) -> a + b),
        SUB((a, b) -> a - b), B_SUB((a, b) -> b - a),
        MUL((a, b) -> a * b),
        DIV((a, b) -> a / b), B_DIV((a, b) -> b / a);

        private final BinaryOperator<Integer> bo;

        Operation(BinaryOperator<Integer> bo) {
            this.bo = bo;
        }

        public int calc(int a, int b) {
            try {
                return bo.apply(a, b);
            } catch (Exception e) {
                return 0;
            }
        }
    }
}
