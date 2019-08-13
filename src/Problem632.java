import java.util.*;

public class Problem632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> arr = sort(nums);
        int k = nums.size();
        int[] cnt = new int[k];
        int len = 200_001;
        int[] ans = new int[2];
        int count = 0;
        for (int r = 0, l = 0; r < arr.size(); r++) {
            if (cnt[arr.get(r)[1]]++ == 0)
                count++;
            while (cnt[arr.get(l)[1]] > 1) {
                cnt[arr.get(l++)[1]]--;
            }
            if (count == k) {
                int[] tmp = new int[]{arr.get(l)[0], arr.get(r)[0]};
                if (tmp[1] - tmp[0] < len) {
                    len = tmp[1] - tmp[0];
                    ans = tmp;
                }
            }
        }
        return ans;
    }

    private List<int[]> sort(List<List<Integer>> nums) {
        int k = nums.size();
        int[] idx = new int[k];
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < k; i++) {
            q.add(new int[]{nums.get(i).get(0), i});
        }
        List<int[]> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] el = q.poll();
            arr.add(el);
            int i = el[1];
            idx[i]++;
            if (idx[i] < nums.get(i).size())
                q.add(new int[]{nums.get(i).get(idx[i]), i});
        }

        return arr;
    }
}
