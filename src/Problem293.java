import java.util.ArrayList;
import java.util.List;

public class Problem293 {
    private List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == '+') {
                sb.setCharAt(i - 1, '-');
                sb.setCharAt(i, '-');
                ans.add(sb.toString());
                sb.setCharAt(i - 1, '+');
                sb.setCharAt(i, '+');
            }
        }
        return ans;
    }
}
