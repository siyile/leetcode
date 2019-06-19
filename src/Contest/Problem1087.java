package Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem1087 {
    public String[] permute(String S) {
        List<String> ans = new ArrayList<>();
        bt(S, 0, ans, new StringBuilder());
        String[] res = new String[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void bt(String S, int i, List<String> ans, StringBuilder temp) {
        if (i == S.length())
            ans.add(temp.toString());
        else if (S.charAt(i) == ',') {
            bt(S, i + 1, ans, temp);
        }
        else if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
            temp.append(S.charAt(i));
            bt(S, i + 1, ans, temp);
        }
        else if (S.charAt(i) == '{') {
            List<Character> choice = new ArrayList<>();
            Collections.sort(choice);
            while (S.charAt(i) != '}') {
                if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
                    choice.add(S.charAt(i));
                }
                i++;
            }
            for (int j = 0; j < choice.size(); j++) {
                temp.append(choice.get(j));
                int len = temp.length();
                bt(S, i + 1, ans, temp);
                temp.delete(len - 1, temp.length());
            }
        }
    }

    public static void main(String[] args) {
        Problem1087 p = new Problem1087();

        Arrays.stream(p.permute("{a,b}c{d,e}f"));
    }
}
