package UpTo850;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem826 {
    public static void main(String[] args) {
        Problem826 p = new Problem826();
        int[] a = new int[]{9, 16, 16, 29, 35, 41, 42, 46, 54, 57, 61, 63, 69, 72, 75, 76, 84, 93, 93, 95};
        int[] b = new int[]{4, 7, 18, 22, 25, 32, 34, 35, 38, 44, 51, 60, 61, 71, 74, 77, 89, 95, 96, 96};
        int[] c = new int[]{29, 81, 10, 90, 13, 11, 88, 50, 7, 28, 28, 85, 66, 45, 50, 89, 93, 7, 89, 40};
        System.out.println(p.maxProfitAssignment(a, b, c));
    }

    public int maxProfitAssignment(int[] difficulty, int[] profits, int[] workers) {
        int n = difficulty.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(profits[i], difficulty[i]));
        }

        Collections.sort(jobs);
        Arrays.sort(workers);

        int profit = 0, i = 0, best = 0;
        for (int worker :
                workers) {
            while (i < n && worker > jobs.get(i).difficulty) {
                best = Math.max(best, jobs.get(i).profit);
                i++;
            }
            profit += best;
        }
        return profit;
    }

    class Job implements Comparable<Job> {
        int profit;
        int difficulty;

        public Job(int profit, int difficulty) {
            this.profit = profit;
            this.difficulty = difficulty;
        }

        @Override
        public int compareTo(Job o) {
            return difficulty - o.difficulty;
        }
    }
}
