package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.stream.IntStream;

public class 조이스틱 implements Solution<Integer>  {
    @Override
    public Integer solution(Object... params) {
        return solution((String) params[0]);
    }

    public int solution(String name) {
        int len = name.length();
        int ans;

        String init = init(len);
        char[] chars1 = init.toCharArray();
        char[] chars2 = name.toCharArray();

        ans = Math.min(len - 1, dfs(replace(init(len), name, 0), name, 0, -1));
        ans += IntStream.range(0, len)
                .reduce(0, (acc, cur) -> acc + change(chars1, chars2, cur));
        return ans;
    }

    int dfs(String src, String dest, int idx, int move) {
        int len = src.length();
        if (move >= len) return Integer.MAX_VALUE;
        if (src.equals(dest)) return move;

        int l = (idx - 1 + len) % len;
        int r = (idx + 1) % len;
        String str = replace(src, dest, idx);

        return Math.min(dfs(str, dest, l, move + 1), dfs(str, dest, r, move + 1));
    }

    int change(char[] src, char[] dest, int idx) {
        char from = src[idx];
        char to = dest[idx];
        if (from == to) return 0;

        int plus = to - from;
        int minus = ('Z' - to) + 1;

        src[idx] = dest[idx];
        return Math.min(plus, minus);
    }

    String replace(String src, String dest, int idx) {
        if (src.charAt(idx) == dest.charAt(idx)) return src;
        StringBuilder builder = new StringBuilder(src);
        builder.setCharAt(idx, dest.charAt(idx));
        return builder.toString();
    }

    String init(int length) {
        StringBuilder builder = new StringBuilder();
        while (length-- > 0) {
            builder.append("A");
        }
        return builder.toString();
    }
}
