package ps.pgmrs.lv3;

import java.util.Arrays;

public class _110_옮기기 {
    public String[] solution(String[] s) {
        return Arrays.stream(s)
                .map(this::solve)
                .toArray(String[]::new);
    }

    // 1. 모든 110을 맨 뒤로 보낸다.
    // 2. 111이 있다면 모든 110을 111 앞으로 보낸다.
    // 3. 마지막이 1로 시작한다면 뒤에서 첫번째인 0의 다음 위치에 모든 110을 삽입한다.
    private String solve(String s) {
        int count = 0;
        int before = s.length();
        s = remove111(s);
        count += (before - s.length()) / 3;

        StringBuilder sb = new StringBuilder("110".repeat(count));

        int firstIndexOf111 = s.indexOf("111");
        if (firstIndexOf111 >= 0 || s.endsWith("1")) {
            firstIndexOf111 = firstIndexOf111 >= 0 ? firstIndexOf111 : s.lastIndexOf("0") + 1;
            return sb.insert(0, s, 0, firstIndexOf111)
                    .append(s, firstIndexOf111, s.length()).toString();
        } else {
            return sb.insert(0, s).toString();
        }
    }

    private String remove111(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '0' && sb.length() >= 2) {
                int len = sb.length() - 2;
                if (sb.substring(sb.length() - 2).equals("11")) {
                    sb.delete(len, sb.length());
                    continue;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
