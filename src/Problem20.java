import java.util.ArrayList;

public class Problem20 {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<Character>();
        int len = s.length();
        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '('){
                stack.add(c);
            }
            else if(c == '}' || c == ']' || c== ')'){
                if (stack.size() == 0) return false;
                char a = stack.remove(stack.size() - 1);
                if (c == '}' && a != '{' || c == ']' && a != '[' || c ==')' && a != '('){
                    return false;
                }
            }
        }
        if (stack.size() != 0) return false;
        return true;
    }

    public static void main(String [] args){
        Problem20 p = new Problem20();
        System.out.println(p.isValid("("));
    }
}
