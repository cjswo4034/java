package ps.pgmrs.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(solve(arrayA, arrayB), solve(arrayB, arrayA));
    }

    private int solve(int[] a, int[] b) {
        return getCommonFactor(a).stream()
                .filter(factor -> Arrays.stream(b).noneMatch(e -> e % factor == 0))
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    private Set<Integer> getCommonFactor(int[] arr) {
        Set<Integer> factors = new HashSet<>();
        final int gcd = Arrays.stream(arr)
                .reduce(this::gcd)
                .getAsInt();

        for (int i = 1, sqrt = (int) Math.sqrt(gcd); i <= sqrt; i++) {
            if (gcd % i == 0) {
                factors.add(i);
                factors.add(gcd / i);
            }
        }

        factors.remove(1);
        return factors;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
