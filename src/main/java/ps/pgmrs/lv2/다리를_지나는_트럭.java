package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution2((int) params[0], (int) params[1], (int[]) params[2]);
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> waiting = new LinkedList<>();

        for (int i = 0; i < bridgeLength; i++) bridge.add(0);
        for (int truckWeight : truckWeights) waiting.add(truckWeight);

        int sum = 0;
        int time = 0;
        do {
            int element = bridge.poll();
            sum -= element;

            if (!waiting.isEmpty() && sum + waiting.peek() <= weight) {
                int truckWeight = waiting.poll();
                bridge.add(truckWeight);
                sum += truckWeight;
            } else {
                bridge.add(0);
            }

            time++;
        } while (sum != 0);

        return time;
    }

    public int solution2(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> bridge = new LinkedList<>();
        Queue<Truck> waiting = new LinkedList<>();

        for (int tw : truckWeights) waiting.add(new Truck(tw));

        int answer = 0;
        int sumOfWeights = 0;
        while (!bridge.isEmpty() || !waiting.isEmpty()) {
            answer++;

            if (bridge.isEmpty()) {
                Truck truck = waiting.poll();
                bridge.add(truck);
                sumOfWeights += truck.weight;
                continue;
            }

            for (Truck t: bridge) t.moving();

            if (bridge.peek().move > bridgeLength) {
                Truck truck = bridge.poll();
                sumOfWeights -= truck.weight;
            }

            if (!waiting.isEmpty() && sumOfWeights + waiting.peek().weight <= weight) {
                Truck truck = waiting.poll();
                sumOfWeights += truck.weight;
                bridge.add(truck);
            }
        }

        return answer;
    }

    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }
}
