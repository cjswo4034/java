package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.fill;

public class 합승_택시_요금 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int) params[0], (int) params[1], (int) params[2], (int) params[3], (int[][]) params[4]);
    }

    // 플로이드
    public int solution2(int n, int s, int a, int b, int[][] fares) {
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int[] fare : fares) {
            dist[fare[0] - 1][fare[1] - 1] = fare[2];
            dist[fare[1] - 1][fare[0] - 1] = fare[2];
        }

        for (int i = 0; i < n; i++) {
            floyd(dist, i, n);
        }

        s--; a--; b--;
        long fare;
        long answer = dist[s][a] + dist[s][b];
        for (int i = 0; i < n; i++) {
            fare = dist[s][i] + dist[i][a] + dist[i][b];
            if (fare < answer) answer = fare;
        }
        return (int) answer;
    }

    void floyd(long[][] dist, int mid, int n) {
        long fare;
        for (int from = 0; from < n; from++) {
            for (int to = 0; to < n; to++) {
                fare = dist[from][mid] + dist[mid][to];
                if (dist[from][to] > fare) {
                    dist[from][to] = fare;
                }
            }
        }
    }

    // 다익스트라
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            adj.get(fare[0]).add(new Pair(fare[1], fare[2]));
            adj.get(fare[1]).add(new Pair(fare[0], fare[2]));
        }

        int[] distA = dijkstra(adj, a, n);
        int[] distB = dijkstra(adj, b, n);
        int[] distS = dijkstra(adj, s, n);

        int answer = distS[a] + distS[b];
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }
        return answer;
    }

    int[] dijkstra(List<List<Pair>> adj, int from, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        fill(dist, Integer.MAX_VALUE);
        dist[from] = 0;
        pq.offer(new Pair(from, 0));
        while (!pq.isEmpty()) {
            int curr = pq.poll().to;

            if (visited[curr]) continue;
            visited[curr] = true;

            for (Pair next : adj.get(curr)) {
                int nv = next.to;
                int nc = next.cost;

                if (dist[nv] > dist[curr] + nc) {
                    dist[nv] = dist[curr] + nc;
                    pq.offer(new Pair(nv, dist[nv]));
                }
            }
        }

        return dist;
    }

    class Pair implements Comparable<Pair> {
        int to;
        int cost;

        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            if (cost != o.cost)
                return Integer.compare(cost, o.cost);
            return Integer.compare(to, o.to);
        }
    }
}
