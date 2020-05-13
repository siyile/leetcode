package UpTo550;

import java.util.*;

public class Problem502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new Project(Profits[i], Capital[i]));
        }
        Collections.sort(projects, new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                if (o1.capital != o2.capital) {
                    return o1.capital - o2.capital;
                } else {
                    return o2.profits - o1.profits;
                }
            }
        });

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        while (k >= 0) {
            while (projects.get(i).capital <= W) {
                q.add(projects.get(i++).profits);
            }
            if (q.isEmpty()) return W;
            W += q.poll();
            k--;
        }
        return W;
    }

    class Project {
        int profits;
        int capital;

        public Project(int profits, int capital) {
            this.profits = profits;
            this.capital = capital;
        }
    }
}
