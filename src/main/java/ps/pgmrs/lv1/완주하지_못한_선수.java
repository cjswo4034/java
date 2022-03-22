package ps.pgmrs.lv1;

import ps.pgmrs.Solution;

import java.util.Arrays;

public class 완주하지_못한_선수 implements Solution<String> {
    @Override
    public String solution(Object... params) {
        return solution((String[]) params[0], (String[]) params[1]);
    }

    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i]))
                return participant[i];
        }

        return participant[participant.length - 1];
    }
}
