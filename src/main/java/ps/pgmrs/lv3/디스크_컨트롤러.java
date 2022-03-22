package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.*;
import java.util.stream.Collectors;

public class 디스크_컨트롤러 implements Solution<Integer> {
    @Override
    public Integer solution(Object... params) {
        return solution((int[][]) params);
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(j -> j.processingTime));
        Queue<Job> sortedJobs = Arrays.stream(jobs)
                .map(input -> new Job(input[0], input[1]))
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        Job job;
        int time = 0;
        int answer = 0;
        while (!sortedJobs.isEmpty()) {
            if (pq.isEmpty() && sortedJobs.peek().start > time) {
                time = sortedJobs.peek().start;
            }

            while (!sortedJobs.isEmpty() && sortedJobs.peek().start <= time) {
                pq.add(sortedJobs.poll());
            }

            if (!pq.isEmpty()) {
                job = pq.poll();
                answer += job.getEnd(time);
                time += job.processingTime;
            }
        }

        while (!pq.isEmpty()) {
            job = pq.poll();
            answer += job.getEnd(time);
            time += job.processingTime;
        }

        return answer / jobs.length;
    }

    class Job implements Comparable<Job>{
        int processingTime;
        int start;

        public Job(int start, int processingTime) {
            this.start = start;
            this.processingTime = processingTime;
        }

        public int getEnd(int start) {
            return start - this.start + processingTime;
        }

        @Override
        public int compareTo(Job o) {
            if (start == o.start)
                return Integer.compare(processingTime, o.processingTime);
            return Integer.compare(start, o.start);
        }
    }
}
