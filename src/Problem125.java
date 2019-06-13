public class Problem125 {
    public boolean isPalindrome(String s) {
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            char leftChar = parseChar(s.charAt(left));
            if (leftChar == ' ') {
                left++;
                continue;
            }
            char rightChar = parseChar(s.charAt(right));
            if (rightChar == ' ') {
                right--;
                continue;
            }
            if (leftChar != rightChar)
                return false;
            left++;
            right--;
        }
        return true;
    }

    public char parseChar(char c) {
        if (c >= 'A' && c <= 'Z') c += 'a' - 'A';
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            return c;
        else
            return ' ';
    }

    public static void main(String[] args) {
        Problem125 p = new Problem125();

        System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
