import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['T' - 'A'] = 2;
        map['G' - 'A'] = 3;
        List<String> ans = new ArrayList<>();
        Set<Integer> words = new HashSet<>();
        int value = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            value <<= 2;
            value += map[s.charAt(i) - 'A'];
            value &= 0xfffff;
            if (i < 9) {
                continue;
            }
            if (!words.add(value)) {
                ans.add(s.substring(i - 9, i + 1));
            }
        }
        return ans;
    }
}
