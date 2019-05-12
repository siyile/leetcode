package UpTo50;

import java.util.ArrayList;
import java.util.List;

public class Problem22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return res;
        }
        int count = 0;
        int i = 0, j = 0;
        String prefix = "";
        getParenthesis(count + 1, i + 1, j, n,  prefix + "(");
        return res;
    }

    public void getParenthesis(int count, int i, int j, int n, String prefix){
        if (count == 0 && i + j == 2 * n){
            res.add(prefix);
            return;
        }
        if (count < 0 || i + j == 2 * n){
            return;
        }
        if (i < n + 1) getParenthesis(count + 1, i + 1, j, n,  prefix + "(");
        if (j < n + 1) getParenthesis(count - 1, i, j + 1, n,  prefix + ")");
    }

    public List<String> res = new ArrayList<String>();

    public static void main(String [] args){
        Problem22 p = new Problem22();
        System.out.println(p.generateParenthesis(3));
    }
}
