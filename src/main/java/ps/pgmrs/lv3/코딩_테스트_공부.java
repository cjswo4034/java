package ps.pgmrs.lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 코딩_테스트_공부 {
    public int solution(int alp, int cop, int[][] problems) {
        final int alpMax = Arrays.stream(problems).mapToInt(prob -> prob[0]).max().getAsInt();
        final int copMax = Arrays.stream(problems).mapToInt(prob -> prob[1]).max().getAsInt();
        int[][] costs = new int[1000][1000];
        int answer = 0;

        PriorityQueue<Power> pq = new PriorityQueue<>(Comparator.comparingInt(Power::getTime));
        List<Problem> problemList = toList(problems);

        init(alp, cop, costs, pq);

        while (!pq.isEmpty()) {
            Power pw = pq.poll();

            System.out.println(pw);

            if (costs[pw.alp][pw.cop] < pw.time) continue;
            if (alpMax <= pw.alp && copMax <= pw.cop) {
                answer = pw.time;
                break;
            }

            for (Problem prob : problemList) {
                int nextAlp = pw.alp + prob.alpRwd;
                int nextCop = pw.cop + prob.copRwd;
                int nextCost = pw.time + prob.cost;

                if (pw.alp < prob.alpReq || pw.cop < prob.copReq) continue;
                if (costs[nextAlp][nextCop] <= nextCost) continue;

                costs[nextAlp][nextCop] = nextCost;
                pq.add(new Power(nextAlp, nextCop, nextCost));
            }
        }

        return answer;
    }

    private void init(int alp, int cop, int[][] costs, PriorityQueue<Power> pq) {
        for (int[] cost : costs)
            Arrays.fill(cost, Integer.MAX_VALUE);
        costs[alp][cop] = 0;
        pq.add(new Power(alp, cop, 0));
    }

    private List<Problem> toList(int[][] problems) {
        List<Problem> problemList = Arrays.stream(problems)
                .map(Problem::new)
                .collect(Collectors.toList());

        problemList.add(new Problem(new int[]{0, 0, 1, 0, 1}));
        problemList.add(new Problem(new int[]{0, 0, 0, 1, 1}));

        problemList.sort(Comparator.comparingInt(Problem::getCost));
        return problemList;
    }

    class Power {
        int alp, cop, time;

        public Power(int alp, int cop, int time) {
            this.alp = alp;
            this.cop = cop;
            this.time = time;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Power{" +
                    "alp=" + alp +
                    ", cop=" + cop +
                    ", time=" + time +
                    '}';
        }
    }

    class Problem {
        int alpReq, copReq;
        int alpRwd, copRwd;
        int cost;

        public Problem(int[] problem) {
            this.alpReq = problem[0];
            this.copReq = problem[1];
            this.alpRwd = problem[2];
            this.copRwd = problem[3];
            this.cost = problem[4];
        }

        public int getCost() {
            return cost;
        }
    }

//    public int solution(int alp, int cop, int[][] problems) {
//        final int maxAlp = Arrays.stream(problems).mapToInt(prob -> prob[0]).max().getAsInt();
//        final int maxCop = Arrays.stream(problems).mapToInt(prob -> prob[1]).max().getAsInt();
//        int[][] costs = initCosts(maxAlp, maxCop);
//
//        alp = Math.min(alp, maxAlp);
//        cop = Math.min(cop, maxCop);
//        costs[alp][cop] = 0;
//
//        for (int i = alp; i <= maxAlp; i++) {
//            for (int j = cop; j <= maxCop; j++) {
//                if (i + 1 <= maxAlp) costs[i + 1][j] = Math.min(costs[i + 1][j], costs[i][j] + 1);
//                if (j + 1 <= maxCop) costs[i][j + 1] = Math.min(costs[i][j + 1], costs[i][j] + 1);
//
//                solve(costs, problems, i, j);
//            }
//        }
//
//        return costs[costs.length - 1][costs[0].length - 1];
//    }
//
//    private int[][] initCosts(int maxAlp, int maxCop) {
//        int[][] costs = new int[maxAlp + 1][maxCop + 1];
//        for (int[] cost : costs) {
//            Arrays.fill(cost, Integer.MAX_VALUE);
//        }
//        return costs;
//    }
//
//    private void solve(int[][] costs, int[][] problems, int alp, int cop) {
//        for (int[] problem : problems) {
//            if (alp < problem[0] || cop < problem[1]) continue;
//
//            int nAlp = Math.min(alp + problem[2], costs.length - 1);
//            int nCop = Math.min(cop + problem[3], costs[0].length - 1);
//            costs[nAlp][nCop] = Math.min(costs[nAlp][nCop], costs[alp][cop] + problem[4]);
//        }
//    }
}
