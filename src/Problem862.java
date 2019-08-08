import java.util.Deque;
import java.util.LinkedList;

public class Problem862 {
    public static void main(String[] args) {
        Problem862 p = new Problem862();

        System.out.println(p.shortestSubarray(new int[]{56, -21, 56, 35, -9}, 61));
    }

    public int shortestSubarray(int[] A, int K) {
        int[] P = new int[A.length];
        int ans = 50_001;
        P[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            P[i] = P[i - 1] + A[i];
        }

        Deque<Integer> monoq = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            while (!monoq.isEmpty() && P[i] <= P[monoq.getLast()]) {
                monoq.pollLast();
            }
            while (!monoq.isEmpty() && P[i] - P[monoq.getFirst()] >= K) {
                ans = Math.min(ans, i - monoq.pollFirst());
            }
            monoq.addLast(i);
        }

        return ans == 50_001 ? -1 : ans;
    }
}
