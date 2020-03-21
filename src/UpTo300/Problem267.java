package UpTo300;

import java.util.ArrayList;
import java.util.List;

public class Problem267 {
    List<String> ans = new ArrayList<>();
    int len;
    int[] count;
    StringBuilder sb = new StringBuilder();
    public List<String> generatePalindromes(String s) {
        len = s.length();
        count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int odd = 0, oddChar = -1;
        for (int i = 0; i < 128; i++) {
            if ((count[i] & 1) == 1) {
                odd++;
                oddChar = i;
                count[i]--;
            }
        }
        if (odd > 1) return ans;
        if (odd == 1) sb.append((char) oddChar);
        generate();
        return ans;
    }

    private void generate() {
        if (sb.length() == len) {
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < 128; i++) {
            if (count[i] != 0) {
                sb.append((char) i);
                sb.insert(0, (char) i);
                count[i] -= 2;
                generate();
                count[i] += 2;
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem267 p = new Problem267();

        System.out.println(p.generatePalindromes("aabbc"));
    }
}
