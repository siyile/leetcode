package UpTo100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem75 {
    public void sortColors(int[] nums) {
        int i = 0;
        int red = 0; int blue = nums.length - 1;
        while (i <= blue) {
            while (i <= blue && nums[i] == 0) {
                swap(nums, red, i);
                i++;
                red++;
            }
            while (i <= blue && nums[blue] == 2) {
                blue--;
            }
            if (i > blue) {
                break;
            }
            if (nums[i] == 2) {
                swap(nums, i, blue);
                blue--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Problem75 p = new Problem75();
        int[] a = {0};
        p.sortColors(a);
        String sb = Arrays.stream(a).mapToObj(y -> y + " ").collect(Collectors.joining());
        System.out.println(sb);
    }
}
