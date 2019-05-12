package UpTo50;

import java.util.HashMap;
import java.util.Map;

public class Problem13 {
    public Map<Character, Integer> hm = new HashMap<Character, Integer>(){{
        put('I', 0);
        put('V', 1);
        put('X', 2);
        put('L', 3);
        put('C', 4);
        put('D', 5);
        put('M', 6);
    }};

    public int romanToInt(String s) {
        int sum = 0;
        int [] b = {1, 5, 10, 50, 100, 500, 1000};
        String [] c ={"IV", "IX", "XL", "XC", "CD", "CM"};
        int [] count = new int[7];
        for (int i = 0; i < 6; i++){
            if (s.contains(c[i])){
                count[i / 2 * 2] -= 2;
            }
        }
        int len = s.length();
        for (int i = 0; i < len; i++){
            count[hm.get(s.charAt(i))]++;
        }
        for (int i = 0; i < 7; i++){
            sum += count[i] * b[i];
        }
        return sum;
    }

    static public void main(String [] args){
        Problem13 p = new Problem13();
        System.out.println(p.romanToInt("LVIII"));
    }
}
