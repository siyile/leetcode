import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem857 {
    public static void main(String[] args) {
        Problem857 p = new Problem857();
        System.out.println(p.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        Worker[] workers = new Worker[n];

        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers);

        Queue<Integer> q = new PriorityQueue<>();

        double ans = 1e9;
        int sumq = 0;

        for (Worker worker :
                workers) {
            sumq += worker.quality;
            q.add(-worker.quality);
            double factor = worker.ratio;
            if (q.size() > K) {
                sumq += q.poll();
            }
            if (q.size() == K) {
                ans = Math.min(ans, factor * sumq);
            }
        }
        return ans;
    }

    static class Worker implements Comparable<Worker> {
        int quality;
        int wage;

        double ratio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;

            this.ratio = 1.0 * wage / quality;
        }

        @Override
        public int compareTo(Worker o) {
            return Double.compare(ratio, o.ratio);
        }
    }
}
