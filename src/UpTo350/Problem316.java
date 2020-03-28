package UpTo350;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem316 {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int[] cnt = new int[26];
        boolean[] visited = new boolean[26];
        for (char ch :
                s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (char ch :
                s.toCharArray()) {
            cnt[ch - 'a']--;

            if (visited[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && ch < stack.peek() && cnt[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            visited[ch - 'a'] = true;
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
}
