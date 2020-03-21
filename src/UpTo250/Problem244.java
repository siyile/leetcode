package UpTo250;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem244 {
    private class WordDistance {
        Map<String, Integer> s2i = new HashMap<>();
        int[] arr;
        int[][] dis;
        public WordDistance(String[] words) {
            int i = 0;
            for (String word :
                    words) {
                if (!s2i.containsKey(word)) {
                    s2i.put(word, i++);
                }
            }
            arr = new int[words.length];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = s2i.get(words[j]);
            }

            dis = new int[s2i.size()][s2i.size()];
            for (int j = 0; j < dis.length; j++) {
                Arrays.fill(dis[j], Integer.MAX_VALUE);
            }
            for (int j = 0; j < arr.length; j++) {
                int i1 = arr[j];
                for (int k = 0; k < j; k++) {
                    int i2 = arr[k];
                    dis[i1][i2] = Math.min(j - k, dis[i1][i2]);
                }
                for (int k = j + 1; k < arr.length; k++) {
                    int i2 = arr[k];
                    dis[i1][i2] = Math.min(k - j, dis[i1][i2]);
                }
            }
        }

        public int shortest(String word1, String word2) {
            int i1 = s2i.get(word1);
            int i2 = s2i.get(word2);
            int ans = dis[i1][i2];
            return Math.min(dis[i1][i2], dis[i2][i1]);
        }
    }

    private void a() {
        WordDistance wordDistance = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(wordDistance.shortest("practice", "coding"));
    }


    public static void main(String[] args) {
        Problem244 p = new Problem244();
        p.a();
    }
}
