import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Problem66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int len = digits.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = len - 1; i >=0 ; i--) {
            int sum = digits[i] + carry;
            ans.add(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            ans.add(1);
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Problem66 p = new Problem66();
        int[] a = {9,9,9};
        Arrays.stream(p.plusOne(a)).forEach(System.out::println);
    }
}
