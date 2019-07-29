import java.util.Collections;
import java.util.PriorityQueue;

public class Problem871 {
    public static void main(String[] args) {
        Problem871 p = new Problem871();
        System.out.println(p.minRefuelStops(1000, 299, new int[][]{{13, 21}, {26, 115}, {100, 47}, {225, 99}, {299, 141}, {444, 198}, {608, 190}, {636, 157}, {647, 255}, {841, 123}}));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0, tank = startFuel, prev = 0;
        for (int[] station :
                stations) {
            int location = station[0];
            int fuel = station[1];
            tank += -location + prev;
            while (!q.isEmpty() && tank < 0) {
                tank += q.poll();
                ans++;
            }
            if (tank < 0) return -1;
            prev = location;
            q.add(fuel);
        }

        tank += -target + prev;
        while (!q.isEmpty() && tank < 0) {
            tank += q.poll();
            ans++;
        }
        if (tank < 0) return -1;

        return ans;
    }
}
