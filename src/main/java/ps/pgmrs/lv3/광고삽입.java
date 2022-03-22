package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

public class 광고삽입 implements Solution<String> {
    @Override
    public String solution(Object... params) {
        return solution((String) params[0], (String) params[1], (String[]) params[2]);
    }

    // https://yjyoon-dev.github.io/kakao/2021/01/29/kakao-insertad/
    // https://programmers.co.kr/learn/courses/30/lessons/72414/solution_groups?language=java
    public String solution(String play_time, String adv_time, String[] logs) {
        int[] ad = new int[100 * 60 * 60];
        int playTime = timeToInt(play_time);
        int advTime = timeToInt(adv_time);

        for (String log: logs) {
            String[] tokens = log.split("-");
            ad[timeToInt(tokens[0])]++;
            ad[timeToInt(tokens[1])]--;
        }

        for (int i = 0; i < ad.length - 1; i++) {
            ad[i + 1] += ad[i];
        }

        int start = 0;
        long sum = 0;
        long max = sum;
        long answer = 0;
        while (start + advTime <= playTime) {
            if (max < sum) {
                max = sum;
                answer = start;
            }
            sum -= ad[start];
            sum += ad[start + advTime];
            start++;
        }

        return timeToStr((int) answer);
    }

    int timeToInt(String time) {
        String[] tokens = time.split(":");
        int intTime = Integer.parseInt(tokens[0]) * 3600;
        intTime += Integer.parseInt(tokens[1]) * 60;
        intTime += Integer.parseInt(tokens[2]);
        return intTime;
    }

    String timeToStr(int time) {
        int h = time / 3600;
        int m = time % 3600 / 60;
        int s = time % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
