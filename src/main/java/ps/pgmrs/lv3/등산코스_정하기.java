package ps.pgmrs.lv3;

import java.util.*;
import java.util.stream.IntStream;

public class 등산코스_정하기 {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        /* init */
        List<List<Node>> adj = toList(paths, n);    // gates, summits 거르면 최적화 가능
        boolean[] isSummit = new boolean[n + 1];
        boolean[] isGate = new boolean[n + 1];
        int[] dist = IntStream.rangeClosed(0, n).map(i -> Integer.MAX_VALUE).toArray();

        /* solve */
        Arrays.sort(summits);
        Arrays.stream(summits).forEach(summit -> isSummit[summit] = true);
        Arrays.stream(gates).forEach(gate -> {
            isGate[gate] = true;
            dijkstra(adj, dist, isGate, isSummit, gate);
        });

        /* then */
        return getAnswer(dist, summits);
    }

    private void dijkstra(List<List<Node>> adj, int[] dist, boolean[] gates, boolean[] summits, int from) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        pq.add(new Node(from, 0));
        dist[from] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (dist[curr.to] < curr.weight || summits[curr.to]) continue;

            for (Node nextNode : adj.get(curr.to)) {
                int next = nextNode.to;
                if (gates[next]) continue;

                int weight = Math.max(curr.weight, nextNode.weight);
                if (dist[next] <= weight) continue;

                pq.offer(new Node(next, dist[next] = weight));
            }
        }
    }

    private int[] getAnswer(int[] dist, int[] summits) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int summit : summits) {
            if (answer[1] > dist[summit]) {
                answer[0] = summit;
                answer[1] = dist[summit];
            }
        }
        return answer;
    }

    private List<List<Node>> toList(int[][] paths, int n) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] path : paths) {
            adj.get(path[0]).add(new Node(path[1], path[2]));
            adj.get(path[1]).add(new Node(path[0], path[2]));
        }
        return adj;
    }

    static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
}
