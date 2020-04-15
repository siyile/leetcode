package UpTo450;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Problem406 {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> output = new LinkedList<>();
        for (int[] person :
                people) {
            output.add(person[1], person);
        }
        return output.toArray(new int[n][2]);
    }
}
