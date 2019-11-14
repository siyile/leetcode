public class Problem791 {
    public String customSortString(String S, String T) {
        int[] cnt = new int[26];
        for (int i = 0; i < T.length(); i++) {
            cnt[T.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            while (cnt[c - 'a']-- > 1) {
                sb.append(c);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (cnt[i]-- > 1) {
                sb.append((char) i + 'a');
            }
        }

        return sb.toString();
    }
}
