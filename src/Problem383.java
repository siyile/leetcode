public class Problem383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char ch :
                magazine.toCharArray()) {
            cnt[ch - 'a'] += 1;
        }

        for (char ch :
                ransomNote.toCharArray()) {
            if (--cnt[ch - 'a'] == -1) {
                return false;
            }
        }
        return true;
    }
}
