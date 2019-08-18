package UpTo100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};
        List<Time> times = new ArrayList<>();
        for (int[] interval :
                intervals) {
            times.add(new Time(interval[0], interval[1]));
        }
        Collections.sort(times);
        int start = times.get(0).start, end = times.get(0).end;
        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{start, end});
        for (Time time :
                times) {
            if (time.start <= end) {
                end = Math.max(end, time.end);
                ans.get(ans.size() - 1)[1] = end;
            } else {
                start = time.start;
                end = time.end;
                ans.add(new int[]{start, end});
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time other) {
            return start - other.start;
        }
    }

    public static void main(String[] args) {
        Problem56 p = new Problem56();
        int[][] a = {{1,4},{4,5}};
        int[][] ans = p.merge(a);
        for (int[] x : ans) {
            System.out.println(x[0] + " " + x[1]);
        }
    }
}
