import java.util.ArrayList;
import java.util.List;

public class Problem68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        List<String> ans = new ArrayList<>();
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            count[i] = words[i].length();
        }
        int start = 0, end = 0;
        int lineCount = -1;
        while (end < len) {
            lineCount += count[end] + 1;
            if (lineCount > maxWidth) {
                ans.add(justify(words, start, end, maxWidth));
                start = end;
                end--;
                lineCount = -1;
            }
            end++;
        }
        ans.add(leftJustify(words, start, end, maxWidth));
        return ans;
    }

    public String justify(String[] words, int start, int end, int maxWidth) {
        if (end == start + 1) {
            return words[start] + " ".repeat(maxWidth - words[start].length());
        }
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += words[i].length();
        }
        int num = end - start - 1;
        int totalSpace = maxWidth - sum;
        int spaceNum = totalSpace / num;
        int bigSpaceNum = totalSpace % num;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            if (i < start + bigSpaceNum)
                sb.append(" ".repeat(spaceNum + 1));
            else if (i != end - 1)
                sb.append(" ".repeat(spaceNum));
        }
        return sb.toString();
    }

    public String leftJustify(String[] words, int start, int end, int maxWidth) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end - 1; i++) {
            count += words[i].length() + 1;
            sb.append(words[i]);
            sb.append(" ");
        }
        count += words[end - 1].length();
        sb.append(words[end - 1]);
        return sb.append(" ".repeat(maxWidth - count)).toString();
    }

    public static void main(String[] args) {
        Problem68 p = new Problem68();
        String[] a = {"Listen","to","many,","speak","to","a","few."};
        System.out.println(p.fullJustify(a, 6));
    }
}
