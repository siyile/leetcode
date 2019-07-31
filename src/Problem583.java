public class Problem583 {
    public static void main(String[] args) {
        Problem583 p = new Problem583();

        System.out.println(p.minDistance("sea", "eat"));
    }

    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        for (int i = 0; i <= ch2.length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= ch1.length; i++) {
            dp[0] = i;
            int[] tmp = new int[word2.length() + 1];
            tmp[0] = dp[0];
            for (int j = 1; j <= ch2.length; j++) {
                if (ch1[i - 1] != ch2[j - 1]) {
                    tmp[j] = Math.min(tmp[j - 1], dp[j]) + 1;
                } else {
                    tmp[j] = dp[j - 1];
                }
            }
            dp = tmp;
        }

        return dp[word2.length()];
    }
}
