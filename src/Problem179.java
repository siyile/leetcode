import java.util.Arrays;
import java.util.Comparator;

public class Problem179 {
    public static void main(String[] args) {
        Problem179 p = new Problem179();
        System.out.println(p.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "";
        String[] aux = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            aux[i] = String.valueOf(nums[i]);
        }


        Arrays.sort(aux, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (aux[0].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for (String x :
                aux) {
            sb.append(x);
        }
        return sb.toString();
    }
}
