public class Problem318 {
    public int maxProduct(String[] words) {
        int[] value = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (char ch :
                    words[i].toCharArray()) {
                value[i] |= 1 << ch - 'a';
            }
        }

        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0 && words[i].length() * words[j].length() > ans) {
                    ans = words[i].length() * words[j].length();
                }
            }
        }
        return ans;
    }
}
