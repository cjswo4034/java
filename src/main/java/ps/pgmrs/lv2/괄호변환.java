package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

public class 괄호변환 implements Solution<String> {
    @Override
    public String solution(Object... params) {
        return solution((String) params[0]);
    }

    public String solution(String p) {
        if (p.isBlank())
            return "";

        String[] tokens = split(p);
        String u = tokens[0];
        String v = tokens[1];

        if (isCorrect(u))
            return u + solution(v);

        String next = "(" + solution(v) + ")";
        return next + reverse(u.substring(1, u.length() - 1));
    }

    String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        for (char ch: str.toCharArray()) {
            builder.append(ch == '(' ? ')' : '(');
        }
        return builder.toString();
    }

    String[] split(String p) {
        for (int i = 0; i < p.length(); i++) {
            int b = getBalancedIdx(p.substring(0, i));
            if (b >= 0) {
                return new String[]{p.substring(0, i), p.substring(i)};
            }
        }
        return new String[]{p, ""};
    }

    int getBalancedIdx(String p) {
        if (p.isBlank()) return -1;
        int count = p.charAt(0) == '(' ? 1 : -1;
        for (int i = 1; i < p.length(); i++) {
            count += p.charAt(i) == '(' ? 1 : -1;
            if (count == 0) return i + 1;
        }
        return -1;
    }

    boolean isCorrect(String p) {
        int count = 0;
        for (char ch: p.toCharArray()) {
            if (ch == '(') count++;
            else {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
