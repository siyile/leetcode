import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem294 {
    public boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap<>();
        return win(s, map);
    }

    private boolean win(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        List<String> nextMove = generatePossibleNextMoves(s);
        if (nextMove.size() == 0) {
            map.put(s, false);
            return false;
        }
        boolean ans = false;
        for (String next :
                nextMove) {
            if (!win(next, map)) {
                ans = true;
                break;
            }
        }
        map.put(s, ans);
        return ans;
    }

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
