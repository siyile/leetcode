import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problem1153 {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.getOrDefault(str1.charAt(i), str2.charAt(i)) != str2.charAt(i))
                return false;
            map.put(str1.charAt(i), str2.charAt(i));
        }
        return new HashSet<Character>(map.values()).size() < 26;
    }
}
