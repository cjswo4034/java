package ps.pgmrs.lv3;

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

    // 내풀이
    public int solution2(int[] a) {
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
}
