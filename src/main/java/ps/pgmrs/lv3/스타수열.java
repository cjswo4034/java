package ps.pgmrs.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class 스타수열 {
    // 모범답안
    public int solution(int[] a) {
        int answer = 0;
        int[] counts = new int[a.length + 1];
        for (int num : a) counts[num]++;

        for (int starNum = 0, len = a.length; starNum < len; starNum++) {
            if (counts[starNum] <= answer) continue;

            int count = 0;
            for (int idx = 0, len2 = len - 1; idx < len2; idx++) {
                if (starNum != a[idx] && starNum != a[idx + 1]) continue;
                if (a[idx] == a[idx + 1]) continue;

                count++;
                idx++;
            }

            answer = Math.max(answer, count);
        }

        return answer * 2;
    }

    // 내풀이 (after refactoring)
    public int solution2(int[] a) {
        // 같은 max가 여러개 있을 수 있음
        int maxValue = count(a);

        int answer = getStarSequenceSize(maxValue, a);

        return answer % 2 == 0 ? answer : answer - 1;
    }

    private int count(int[] a) {
        int maxCount = 0, maxValue = 0;
        int[] count = new int[a.length + 1];
        for (int idx = 0, lastIdx; idx < a.length; idx++) {
            lastIdx = getLastIdx(a, idx);

            if (idx != lastIdx) {
                count[a[idx]]++;
                idx = lastIdx;
            }

            if (++count[a[idx]] > maxCount) {
                maxCount = count[a[idx]];
                maxValue = a[idx];
            }
        }
        return maxValue;
    }

    private int getLastIdx(int[] a, int idx) {
        int j = idx;
        while (j < a.length && a[idx] == a[j]) j++;
        j--;
        return j;
    }

    private int getStarSequenceSize(int value, int[] a) {
        int mem = a[0], size = 1;
        for (int i = 1; i < a.length; i++) {
            if (size % 2 == 0 || (value == a[i] ^ value == mem)) {
                mem = a[i];
                size++;
            }
        }
        return size;
    }

    // before refactoring
    public int solution3(int[] a) {
        Count[] counts = IntStream.rangeClosed(0, getMax(a))
                .mapToObj(idx -> new Count(idx, 0))
                .toArray(Count[]::new);

        count(a, counts);

        Arrays.sort(counts, Comparator.comparingInt(Count::getCount));

        int answer = getAnswer(a, counts);

        return answer % 2 == 0 ? answer : answer - 1;
    }

    private int getAnswer(int[] a, Count[] counts) {
        int result = 0;
        int max = counts[0].count;
        for (Count count : counts) {
            if (count.count != max) break;
            result = Math.max(result, getStarSequence(count.value, a).size());
        }
        return result;
    }

    private List<Integer> getStarSequence(int value, int[] a) {
        List<Integer> starSequence = new ArrayList<>();

        for (int e : a) {
            int size = starSequence.size();
            if (size % 2 == 1) {
                int prev = starSequence.get(size - 1);
                if ((e != value && prev == value) || (e == value && prev != value)) starSequence.add(e);
            } else
                starSequence.add(e);
        }

        return starSequence;
    }

    private void count(int[] a, Count[] counts) {
        for (int i = 0, j; i < a.length; i++) {
            j = i;
            while (j < a.length && a[i] == a[j]) j++;
            j--;

            if (i != j) {
                counts[a[i]].count += 2;
                i = j;
            } else
                counts[a[i]].count++;
        }
    }

    private int getMax(int[] a) {
        return Arrays.stream(a).max().getAsInt();
    }


    class Count {
        int value, count;

        public Count(int value, int count) {
            this.value = value;
            this.count = count;
        }

        public int getCount() {
            return -count;
        }
    }
}

