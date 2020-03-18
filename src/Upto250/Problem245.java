package Upto250;

public class Problem245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dis = words.length, i1 = dis, i2 = -dis;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    i2 = i1;
                }
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
            dis = Math.min(dis, Math.abs(i1 - i2));
        }
        return dis;
    }
}
