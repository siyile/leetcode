import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer x :
                stones) {
            q.add(x);
        }
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            if (a != b)
                q.add(Math.abs(a - b));
        }
        if (q.size() == 0) return 0;
        else return q.poll();
    }
}
