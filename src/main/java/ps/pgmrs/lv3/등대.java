package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.ArrayList;
import java.util.List;

// BOJ 2533과 비슷함
public class 등대 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int) params[0], (int[][]) params[1]);
    }

    public int solution(int n, int[][] lighthouse) {
        List<List<Integer>> adj = initAdj(n, lighthouse);
        int[] answer = dfs(adj, 1, 0);

        return Math.min(answer[0], answer[1]);
    }

    private int[] dfs(List<List<Integer>> adj, int node, int prev) {
        int[] currRes = {0, 1}; // 현재 등대를 [0]: 안켠다, [1]: 켠다
        for (int next : adj.get(node)) {
            if (next == prev) continue;
            int[] nextRes = dfs(adj, next, node);
            currRes[0] += nextRes[1];                       // 현재 등대를 안킨다면 다음 등대는 켜져있어야됨
            currRes[1] += Math.min(nextRes[0], nextRes[1]); // 현재 등대를 킨다면 다음 등대는 키거나 안키거나 둘 중 최솟값
        }
        return currRes;
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
