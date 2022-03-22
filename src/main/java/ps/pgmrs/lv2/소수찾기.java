package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 소수찾기 implements Solution<Integer> {
    final Set<Integer> set = new HashSet<>();
    final boolean[] isPrime = primes();

    @Override
    public Integer solution(Object... params) {
        return solution2((String) params[0]);
    }

    public int solution2(String strNumbers) {
        permutation("", strNumbers);
        return (int) set.stream()
                .filter(number -> isPrime[number])
                .count();
    }

    void permutation(String prefix, String remain) {
        if (!prefix.isBlank())
            set.add(Integer.parseInt(prefix));

        for (int i = 0, len = remain.length(); i < len; i++) {
            permutation(prefix + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1, len));
        }
    }

    /////////////////////////////////////////////////////////////////////

    public int solution(String strNumbers) {
        boolean[] visited = new boolean[strNumbers.length()];
        int[] numbers = new int[visited.length];
        int[] number = new int[visited.length];
        for (int i = 0; i < strNumbers.length(); i++) {
            numbers[i] = strNumbers.charAt(i) - '0';
        }
        dfs(visited, numbers, number, 0);
        return set.size();
    }

    void dfs(boolean[] visited, int[] numbers, int[] number, int depth) {
        if (depth == numbers.length) {
            int num = concat(number);
            if (isPrime[num])
                set.add(num);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;

            number[depth] = numbers[i];
            dfs(visited, numbers, number, depth + 1);
            number[depth] = -1;
            dfs(visited, numbers, number, depth + 1);

            visited[i] = false;
        }
    }

    int concat(int[] arr) {
        int res = 0;
        for (int e : arr) {
            if (e < 0) continue;
            res += e;
            res *= 10;
        }
        return res / 10;
    }

    boolean[] primes() {
        final int max = 10000000;
        boolean[] isPrime = new boolean[max];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2, len = (int) Math.sqrt(max); i <= len; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * 2; j < max; j += i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
