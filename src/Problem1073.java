import java.util.*;

public class Problem1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();
        int i = arr1.length - 1;
        int k = arr2.length - 1;
        while (i >= 0 || k >= 0) {
            ans.add((i >= 0 ? arr1[i--] : 0) + (k >= 0 ? arr2[k--] : 0));
        }
        ans.add(0);
        ans.add(0);
        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j) > 1) {
                if (ans.get(j + 1) > 0) {
                    ans.set(j + 1, ans.get(j + 1) - 1);
                } else {
                    ans.set(j + 1, ans.get(j + 1) + 1);
                    ans.set(j + 2, ans.get(j + 2) + 1);
                }
                ans.set(j, ans.get(j) - 2);
            }
        }
        for (int j = ans.size() - 1; j > 0 && ans.get(j) == 0; j--) {
            ans.remove(j);
        }
        int[] res = new int[ans.size()];
        for (int j = 0; j < ans.size(); j++) {
            res[j] = ans.get(ans.size() - 1 - j);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1073 p = new Problem1073();
        Arrays.stream(p.addNegabinary(new int[]{1}, new int[]{1})).forEach(System.out::println);
    }
}
