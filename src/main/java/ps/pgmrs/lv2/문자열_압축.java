package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

public class 문자열_압축 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((String) params[0]);
    }

    public int solution(String s) {
        int answer = s.length();
        for (int size = 1; size <= s.length(); size++) {
            answer = Math.min(answer, compress(s, size));
        }
        return answer;
    }

    int compress(String str, int size) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, len = str.length(); i + size <= len;) {
            String curr = str.substring(i, i + size);

            int count = 1;
            for (int j = i + size; j + size <= len; j += size) {
                if (curr.equals(str.substring(j, j + size))) {
                    count++;
                } else {
                    break;
                }
            }

            if (count > 1) {
                builder.append(count).append(curr);
            } else {
                builder.append(curr);
            }
            i += count * size;
        }
        if (str.length() % size != 0) {
            builder.append(str.substring(str.length() - (str.length() % size)));
        }
        return builder.length();
    }
}
