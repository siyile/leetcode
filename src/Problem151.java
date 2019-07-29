public class Problem151 {
    public static void main(String[] args) {
        Problem151 p = new Problem151();
        System.out.println(p.reverseWords("  hello   world!  "));
    }

    public String reverseWords(String s) {
        s = s.trim();
        boolean word = false;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == ' ')
                i++;
            if (!word) {
                start = i;
                word = true;
            }
            if (word && ((i + 1 < s.length() && s.charAt(i + 1) == ' ') || i == s.length() - 1)) {
                sb.append(reverse(s.substring(start, i + 1)));
                if (i != s.length() - 1) {
                    sb.append(' ');
                }
                word = false;
            }
        }
        return sb.reverse().toString();
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
