package UpTo1100;

import java.util.*;

public class Problem1096 {
    public static void main(String[] args) {
        Problem1096 p = new Problem1096();

        System.out.println(p.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }

    public List<String> braceExpansionII(String e) {
        if (e.length() < 2)
            return Arrays.asList(e);
        if (e.charAt(0) == '{') {
            int counter = 1;
            int i = 1;
            for (; i < e.length(); i++) {
                char ch = e.charAt(i);
                if (ch == '{')
                    counter++;
                else if (ch == '}')
                    counter--;
                if (counter == 0)
                    break;
            }

            Set<String> set = new HashSet<>();
            String sub = e.substring(1, i);
            List<String> subs = sep(sub);
            for (String sub1 :
                    subs) {
                List<String> list = braceExpansionII(sub1);
                set.addAll(list);
            }

            List<String> remain = braceExpansionII(e.substring(i + 1));
            List<String> ans = new ArrayList<>();
            for (String s :
                    set) {
                for (String aRemain :
                        remain) {
                    ans.add(s + aRemain);
                }
            }
            Collections.sort(ans);
            return ans;
        } else {
            String sub = e.charAt(0) + "";
            List<String> remain = braceExpansionII(e.substring(1));
            List<String> ans = new ArrayList<>();
            for (String aRemain :
                    remain) {
                ans.add(sub + aRemain);
            }
            Collections.sort(ans);
            return ans;
        }
    }

    private List<String> sep(String e) {
        List<String> ans = new ArrayList<>();
        int counter = 0;
        int i = 0;
        for (int j = 0; j < e.length(); j++) {
            char ch = e.charAt(j);
            if (ch == ',') {
                if (counter == 0) {
                    ans.add(e.substring(i, j));
                    i = j + 1;
                }
            } else if (ch == '{')
                counter++;
            else if (ch == '}')
                counter--;
        }
        ans.add(e.substring(i));
        return ans;
    }
}
