package ps.pgmrs.lv3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 양과_늑대 {
    private List<List<Integer>> adj;
    private int[] info;
    private int answer;

    public int solution(int[] info, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        init(info, edges);

        solve(visited, 0, 1, 0);

        return answer;
    }

    private void init(int[] info, int[][] edges) {
        this.adj = new ArrayList<>();
        this.info = info;
        this.answer = 0;

        for (int i : info) adj.add(new ArrayList<>());
        for (int[] edge : edges) adj.get(edge[0]).add(edge[1]);
    }

    private void solve(Set<Integer> visited, int parents, int sheep, int wolves) {
        if (sheep <= wolves) return;

        answer = Math.max(answer, sheep);
        for (Integer visit : visited) {
            if ((parents & (1 << visit)) > 0) continue;

            boolean isVisitedAllChild = true;
            for (Integer next : adj.get(visit)) {
                if (visited.contains(next)) continue;

                isVisitedAllChild = false;

                Set<Integer> nextVisit = new HashSet<>(visited);
                nextVisit.add(next);

                if (info[next] == 0) solve(nextVisit, parents, sheep + 1, wolves);
                else solve(nextVisit, parents, sheep, wolves + 1);
            }

            if (isVisitedAllChild) parents = parents | (1 << visit);
        }
    }
}

