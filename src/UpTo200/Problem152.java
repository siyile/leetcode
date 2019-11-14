package UpTo200;

public class Problem152 {
    public int maxProduct(int[] nums) {
        if (nums.length < 2) return nums[0];
        int max = nums[0];
        int prod = 1;
        boolean even = true;
        int r = 0, l = 0;
        while (r < nums.length) {
            while (r < nums.length && even) {
                if (nums[r] == 0) {
                    while (r < nums.length && nums[r] == 0) r++;
                    max = Math.max(0, max);
                    l = r;
                    if (r >= nums.length) break;
                    prod = nums[r];
                    even = prod > 0;
                    r++;
                    continue;
                } else if (nums[r] < 0){
                    max = Math.max(prod, max);
                    even = false;
                }
                prod *= nums[r];
                r++;
            }
            if (r == nums.length) {
                max = Math.max(prod, max);
                break;
            }
            while (l < r && !even) {
                if (nums[l] < 0) {
                    even = true;
                }
                prod /= nums[l];
                l++;
            }
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        Problem152 p = new Problem152();

        System.out.println(p.maxProduct(new int[]{0,-2,-3}));
    }
}
