package ps.pgmrs.lv3;

public class 카운트_다운 {
    public int[] solution(int target) {
        int[][] dist = initDist(target);
        for (int i = 61; i <= target; i++) {
            dist[i][0] = dist[i - 20][0] + 1;
            dist[i][1] = dist[i - 20][1] + 1;
            arr(dist[i], dist[i - 50][0] + 1, dist[i - 50][1] + 1);
            arr(dist[i], dist[i - 40][0] + 1, dist[i - 40][1]);
            arr(dist[i], dist[i - 60][0] + 1, dist[i - 60][1]);
        }

        return dist[target];
    }

    public int[][] initDist(int target) {
        int[][] dist = new int[target + 1][2];
        for (int i = 1, len = Math.min(60, target); i <= len; i++) {
            dist[i][0] = dist[i][1] = 2;
            if (i <= 20 || i == 50) set(dist[i], 1, 1);
            else if (i % 3 == 0) {
                set(dist[i], 1, 0);
            } else if (i <= 40) {
                if (i % 2 == 0) set(dist[i], 1, 0);
            } else if (i < 50) {
                set(dist[i], 2, 1);
            }
        }
        return dist;
    }

    private void arr(int[] arr, int a, int b) {
        if (arr[0] < a) return;
        if (arr[0] > a || arr[1] < b)
            set(arr, a, b);
    }

    private void set(int[] arr, int x, int y) {
        arr[0] = x;
        arr[1] = y;
    }

    // 60까지 일일히 채운다.
    // 61부터는 -(20, 40, 50, 60) 해서 채운다.
    private int[] solve(int[][] dist, int target, int count, int singleOrBool) {
        if (target < 0) return new int[]{Integer.MAX_VALUE, 0};
        if (target == 0) return dist[target] = new int[]{count, singleOrBool};
        if (dist[target][0] != Integer.MAX_VALUE) return dist[target];

        if (target <= 20 || target == 50) return dist[target] = new int[]{1, 1};
        if (target <= 40 && target % 2 == 0) return dist[target] = new int[]{1, 0};
        if (target <= 60 && target % 3 == 0) return dist[target] = new int[]{1, 0};
        if (40 < target && target <= 50) return dist[target] = new int[]{2, 1};
        if (target <= 70) return dist[target] = new int[]{2, 2};

//        dist[target] = solve(dist, target - 20, count + 1, singleOrBool + 1);
//        dist[target] = arr(dist[target], solve(dist, target - 40, count + 1, singleOrBool));
//        dist[target] = arr(dist[target], solve(dist, target - 50, count + 1, singleOrBool + 1));
//        return dist[target] = arr(dist[target], solve(dist, target - 60, count + 1, singleOrBool));
        return null;
    }
}
