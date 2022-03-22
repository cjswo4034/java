package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 가장_큰_수 implements Solution<String> {
    @Override
    public String solution(Object... params) {
        return solution((int[])params[0]);
    }

    public String solution(int[] numbers) {
        String ans = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(new MyComparator())
                .collect(Collectors.joining());

        return isZero(ans) ? "0" : ans;
    }

    public boolean isZero(String str) {
        for (char ch: str.toCharArray()) {
            if (ch != '0') return false;
        }
        return true;
    }

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1.equals(s2)) return 0;
            int i = 0, j = 0;
            int len1 = s1.length();
            int len2 = s2.length();
            do {
                if (s1.charAt(i) != s2.charAt(j))
                    return -Integer.compare(s1.charAt(i), s2.charAt(j));

                if (++i == len1) i = 0;
                if (++j == len2) j = 0;
            } while (i != j || i != 0);
            return 0;
        }

        /*
        public int compare(String s1, String s2) {
            return -Integer.compare(Integer.parseInt(s1 + s2), Integer.parseInt(s2 + s1));
        }
        * */
    }
}