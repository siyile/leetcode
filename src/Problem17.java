import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem17 {
    public char[][] converter = {{'a','b','c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> combineLetter = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        generateList(digits, "");
        Collections.sort(combineLetter);
        List<String> res = new ArrayList<>();
        res.add(combineLetter.get(0));
        for (int i = 1; i < combineLetter.size(); i++){
            if (combineLetter.get(i) != combineLetter.get(i - 1)) res.add(combineLetter.get(i));
        }
        return res;
    }

    public void generateList(String digits, String s){
        if (digits.length() != 0){
            int now = digits.charAt(0) - '2';
            for (int i = 0; i < converter[now].length; i++){
                generateList(digits.substring(1), s + converter[now][i]);
            }
        }
        else {
            combineLetter.add(s);
        }
    }

    public static void main(String [] args){
        Problem17 p = new Problem17();
        System.out.println(p.letterCombinations("23"));
    }
}
