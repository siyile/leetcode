package UpTo200;

import java.util.Arrays;

public class Problem164 {
    public int maximumGap2(int[] nums) {
        if (nums.length < 2) return 0;
        int[] aux = new int[nums.length];

        int exp = 1;
        int radix = 10;

        int maxVal = Integer.MIN_VALUE;
        for (Integer x :
                nums) {
            if (x > maxVal) {
                maxVal = x;
            }
        }

        while (maxVal / exp > 0) {
            int[] count = new int[radix];

            for (Integer x :
                    nums) {
                count[(x / exp) % radix]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % radix]] = nums[i];
            }

            System.arraycopy(aux, 0, nums, 0, nums.length);
        }

        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }

        return ans;
    }

    class Bucket{
        boolean used = false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (Integer x :
                nums) {
            if (x > maxVal) {
                maxVal = x;
            }
            if (x < minVal) {
                minVal = x;
            }
        }

        int b = Math.max(1, (maxVal - minVal) / nums.length);
        int k = (maxVal - minVal) / b + 1;

        Bucket[] buckets = new Bucket[k];

        for (int i = 0; i < k; i++) {
            buckets[i] = new Bucket();
        }

        for (Integer x :
                nums) {
            int i = (x - minVal) / b;
            buckets[i].used = true;
            buckets[i].min = Math.min(buckets[i].min, x);
            buckets[i].max = Math.max(buckets[i].max, x);
        }

        int prev = minVal;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (!buckets[i].used) continue;
            ans = Math.max(ans, buckets[i].min - prev);
            prev = buckets[i].max;
        }

        return ans;
    }
}
