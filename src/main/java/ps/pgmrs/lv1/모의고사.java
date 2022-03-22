package ps.pgmrs.lv1;

import ps.pgmrs.Solution;

import java.util.Arrays;
import java.util.List;

// 1. 패턴을 answers의 길이만큼 늘린다.
// 2. 1번 배열과 answers를 비교하여 일치하는 수를 반환한다.
public class 모의고사 implements Solution<int[]> {
    private final List<Person> people = Arrays.asList(
            new Person(1, new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}),
            new Person(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5}),
            new Person(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));

    @Override
    public int[] solution(Object... params) {
        return solution((int[])params[0]);
    }

    public int[] solution(int[] answers) {
//        final int highScore = people.stream()
//                .peek(person -> person.extend(answers.length))
//                .mapToInt(person -> person.compare(answers))
//                .highScore()
//                .getAsInt();
        final int highScore = people.stream()
                .mapToInt(person -> person.compare2(answers))
                .max()
                .getAsInt();

        return people.stream()
                .filter(person -> person.score == highScore)
                .mapToInt(person -> person.index)
                .toArray();
    }

    class Person implements Comparable<Person> {
        private final int index;

        private int[] pattern;
        private int score;

        public Person(int index, int[] pattern) {
            this.index = index;
            this.pattern = pattern;
        }

        public void extend(int length) {
            final int oldLength = this.pattern.length;
            final int quotient = length / oldLength;
            final int remainder = length % oldLength;
            int[] pattern = new int[length];

            for (int i = 0; i < quotient; i++) {
                System.arraycopy(this.pattern, 0, pattern, i * oldLength, oldLength);
            }

            System.arraycopy(this.pattern, 0, pattern, quotient * oldLength, remainder);
            this.pattern = pattern;
        }

        public int compare(int[] answers) {
            assert pattern.length == answers.length;

            int answer = 0;
            for (int i = 0; i < answers.length; i++) {
                if (pattern[i] == answers[i])
                    answer++;
            }
            return score = answer;
        }

        public int compare2(int[] answers) {
            int answer = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == pattern[i % pattern.length]) {
                    answer++;
                }
            }
            return score = answer;
        }

        @Override
        public int compareTo(Person o) {
            if (score == o.score)
                return Integer.compare(index, o.index);
            return -Integer.compare(score, o.score);
        }
    }
}
