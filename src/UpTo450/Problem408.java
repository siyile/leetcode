package UpTo450;

public class Problem408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int j = 0, i = 0;
        while (i < abbr.length()) {
            if (Character.isLetter(abbr.charAt(i))) {
                if (j >= word.length() || abbr.charAt(i++) != word.charAt(j++)) {
                    return false;
                }
            } else {
                int left = i;
                if (abbr.charAt(i) == '0') return false;
                while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                    i++;
                }
                j += Integer.parseInt(abbr.substring(left, i));
            }
        }
        return i == abbr.length() && j == word.length();
    }
}
