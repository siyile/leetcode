import java.util.Arrays;

public class Problem167 {
    public static void main(String[] args) {
        Problem167 p = new Problem167();

        Arrays.stream(p.twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(System.out::println);
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (true) {
            while (numbers[left] + numbers[right] > target) right--;
            while (numbers[left] + numbers[right] < target) left++;
            if (numbers[left] + numbers[right] == target) return new int[]{left, right};
        }
    }
}
