package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.*;

public class 부대복귀 implements Solution<int[]> {
    @Override
    public int[] solution(Object... params) {
        return solution((int) params[0], (int[][]) params[1], (int[]) params[2], (int) params[3]);
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> adj = initAdj(n, roads);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{destination, 0});

        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[destination] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int next : adj.get(curr[0])) {
                if (costs[next] > curr[1] + 1) {
                    q.add(new int[]{next, costs[next] = curr[1] + 1});
                }
            }
        }

        return Arrays.stream(sources)
                .map(source -> costs[source] == Integer.MAX_VALUE ? -1 : costs[source])
                .toArray();
    }

    private List<List<Integer>> initAdj(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        return adj;
    }
}
