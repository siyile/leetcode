import java.util.*;

public class Problem131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        bt(0, s, ans, new ArrayList<>());
        return ans;
    }

    public void bt (int start, String s, List<List<String>> ans, List<String> temp) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = start; i < s.length(); i++) {
            if (check(start, i, s)) {
                temp.add(s.substring(start, i + 1));
                bt(i + 1, s, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean check(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem131 p = new Problem131();
        System.out.println(p.partition("aab"));
    }
}
