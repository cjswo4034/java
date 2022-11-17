package ps.pgmrs.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 우박수열_정적분 {
    public double[] solution(int k, int[][] ranges) {
        double[] areas = getAreas(k);

        return Arrays.stream(ranges)
                .map(range -> new int[]{range[0], areas.length + range[1] - 1})
                .mapToDouble(range -> getIntegral(areas, range))
                .toArray();
    }

    private double getIntegral(double[] areas, int[] range) {
        return range[1] < range[0] ? -1 : areas[range[1]] - areas[range[0]];
    }

    private double[] getAreas(int k) {
        List<Integer> collatzConjecture = getCollatzConjecture(k);
        double[] areaAcc = new double[collatzConjecture.size()];
        for (int i = 1; i < areaAcc.length; i++) {
            areaAcc[i] = areaAcc[i - 1] + integrate(collatzConjecture.get(i - 1), collatzConjecture.get(i));
        }
        return areaAcc;
    }

    private double integrate(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        return (max - min) / 2.0 + min;
    }

    private List<Integer> getCollatzConjecture(int k) {
        List<Integer> result = new ArrayList<>();
        while (k != 1) {
            result.add(k);
            k = k % 2 == 0 ? k / 2 : k * 3 + 1;
        }
        result.add(1);
        return result;
    }
}
