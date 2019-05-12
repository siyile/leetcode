package UpTo50;

public class Problem45 {
    public int jump1(int[] nums) {
        int len = nums.length;
        int[] dist = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            int value = nums[i];
            if (value == 0) {
                dist[i] = Integer.MAX_VALUE / 2;
                continue;
            }
            int min = Integer.MAX_VALUE;
            if (value + i >= len - 1) {
                min = 0;
            } else {
                int end = i + value > len - 2 ? len - 2 : i + value;
                for (int j = i + 1; j <= end; j++) {
                    min = min < dist[j] ? min : dist[j];
                }
            }
            dist[i] = min + 1;
        }
        return dist[0];
    }

    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        if (nums[0] >= len - 1) {
            return 1;
        }
        int cur = 0;
        int count = 0;
        int next = 0;
        while (cur < len - 1){
            int max = -1;
            int value = nums[cur];
            for (int i = cur + 1; i <= cur + value; i++) {
                int dist = nums[i] + i;
                if (max < dist) {
                    max = dist;
                    next = i;
                }
                if (max >= len - 1) {
                    count += 2;
                    return count;
                }
            }
            cur = next;
            count++;
        }
        return count;
    }

    public static void main(String[] args)  {
        Problem45 p = new Problem45();
        int[] a = {1,2};
        System.out.println(p.jump(a));
    }
}
