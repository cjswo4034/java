package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.*;

public class 카드_짝_맞추기 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int[][]) params[0], (int) params[1], (int) params[2]);
    }

    private static final int[][] DIR = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static final int MAX = (int)1e9;
    private static final int LEN = 4;

    public int solution(int[][] board, int r, int c) {
        List<CardSet> cardSets = new ArrayList<>();
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (board[i][j] != 0) {
                    cards.add(new Card(board[i][j], new Point(i, j)));
                    if (cards.size() % 2 == 0) {
                        cardSets.add(new CardSet());
                    }
                }
            }
        }

        for (Card card: cards)
            cardSets.get(card.index - 1).set(card);

        return dfs(cardSets, board, new Point(r, c), 0);
    }

    int dfs(List<CardSet> cards, int[][] board, Point current, int select) {
        if (select == cards.size()) return 0;

        int result = MAX;
        for (CardSet cardSet: cards) {
            if (cardSet.isAllOpened()) continue;

            Card first = cardSet.first;
            Card second = cardSet.second;

            int distA = dijkstra(board, current, first.point) + dijkstra(board, first.point, second.point) + 2;
            int distB = dijkstra(board, current, second.point) + dijkstra(board, second.point, first.point) + 2;

            Card.upsideDown(board, first, second);

            int result1 = Math.min(
                    distA + dfs(cards, board, second.point, select + 1),
                    distB + dfs(cards, board, first.point, select + 1));

            Card.upsideDown(board, first, second);

            result = Math.min(result, result1);
        }
        return result;
    }

    int dijkstra(int[][] board, Point from, Point to) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(p -> p.d));
        int[][] dist = new int[LEN][LEN];
        for (int[] row: dist) Arrays.fill(row, MAX);

        pq.add(new Point(from.x, from.y, 0));
        dist[from.x][from.y] = 0;
        while (!pq.isEmpty()) {
            Point curr = pq.poll();

            if (dist[curr.x][curr.y] < curr.d) continue;
            if (curr.equals(to)) return dist[to.x][to.y];

            for (DIRECTION dir: DIRECTION.values()) {
                if (!curr.movable(dir)) continue;

                Point next = curr;
                while (next.movable(dir)) {
                    next = next.move(dir);

                    if (board[next.x][next.y] != 0) break;

                    if (dist[next.x][next.y] > next.d) {
                        dist[next.x][next.y] = next.d;
                        pq.add(next);
                    }
                }

                if (next.isInner() && dist[next.x][next.y] > curr.d + 1) {
                    dist[next.x][next.y] = curr.d + 1;
                    pq.add(new Point(next.x, next.y, curr.d + 1));
                }
            }
        }
        return dist[to.x][to.y];
    }

    static class CardSet {
        Card first;
        Card second;

        public boolean isAllOpened() {
            return first.isOpened && second.isOpened;
        }

        public void set(Card card) {
            if (first == null) first = card;
            else second = card;
        }
    }

    static class Card {
        int index;
        Point point;
        boolean isOpened;

        public Card(int index, Point point) {
            this.index = index;
            this.point = point;
        }

        public static void upsideDown(int[][] board, Card... cards) {
            for (Card card: cards) {
                Point point = card.point;
                board[point.x][point.y] = board[point.x][point.y] == 0 ? card.index : 0;
                card.isOpened ^= true;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return index == card.index;
        }
    }

    static class Point {
        int x;
        int y;
        int d;

        public Point() { }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        boolean isInner() {
            return x >= 0 && y >= 0 && x < LEN && y < LEN;
        }

        boolean movable(DIRECTION dir) {
            int nx = x + DIR[dir.ordinal()][0];
            int ny = y + DIR[dir.ordinal()][1];
            return nx >= 0 && ny >= 0 && nx < LEN && ny < LEN;
        }

        Point move(DIRECTION dir) {
            Point next = new Point();
            next.x = x + DIR[dir.ordinal()][0];
            next.y = y + DIR[dir.ordinal()][1];
            next.d = d + 1;
            return next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }

    enum DIRECTION {
        LEFT, RIGHT, UP, DOWN
    }
}
