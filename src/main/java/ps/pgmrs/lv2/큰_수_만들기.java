package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.Stack;

public class 큰_수_만들기 implements Solution<String> {
    @Override
    public String solution(Object... params) {
        return solution2((String) params[0], (int) params[1]);
    }

    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder(number);
        for (int i = 0; i < k; i++) {
            erase(builder);
        }
        return builder.toString();
    }

    void erase(StringBuilder number) {
        boolean deleted = false;
        for (int i = 0, len = number.length() - 1; i < len; i++) {
            if (number.charAt(i) < number.charAt(i + 1)) {
                number.deleteCharAt(i);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            number.deleteCharAt(number.length() - 1);
    }

    ////////////////////////////////////////////////////////

    public String solution2(String number, int k) {
        return erase(number, k);
    }

    String erase(String number, int k) {
        char[] chars = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (char ch: number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < ch && k-- > 0) {
                stack.pop();
            }
            stack.push(ch);
        }

        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.get(i);
        }

        return new String(chars);
    }
}
