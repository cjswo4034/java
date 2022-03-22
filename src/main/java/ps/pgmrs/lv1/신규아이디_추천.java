package ps.pgmrs.lv1;

import ps.pgmrs.Solution;

public class 신규아이디_추천 implements Solution<String> {
    @Override
    public String solution(Object... params) {
        return solution((String) params[0]);
    }

    public String solution(String newId) {
        newId = newId.toLowerCase();
        newId = newId.replaceAll("[^a-z0-9-_.]", "");
        newId = newId.replaceAll("[.]{2,}", ".");
        newId = newId.replaceAll("^[.]+|[.]+$", "");
        newId = newId.isBlank() ? "a" : newId;
        newId = newId.length() < 16 ? newId : newId.substring(0, 15);
        newId = newId.replaceAll("^[.]+|[.]+$", "");
        return extend(newId);
    }

    String extend(String newId) {
        int diff = 3 - newId.length();
        if (diff <= 0) return newId;

        char lastChar = newId.charAt(newId.length() - 1);
        return newId + String.valueOf(lastChar).repeat(diff);
    }
}
