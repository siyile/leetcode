import java.util.HashMap;
import java.util.Map;

public class Problem12 {
    public Map<Integer, String> hm = new HashMap<>(){{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
        put(4, "IV");
        put(9, "IX");
        put(40, "XL");
        put(90, "XC");
        put(400, "CD");
        put(900, "CM");
    }};

    public StringBuilder res = new StringBuilder();


    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        while (sb.length() < 4){
            sb.insert(0, 0);
        }
        for (int i = 0; i < sb.length(); i++){
            int digit = Character.getNumericValue(sb.charAt(i));
            if (digit != 0){
                int originDigit = (int) Math.pow(10, (3 - i)) * digit;
                if (originDigit >= 1000) digitToRoman(digit, 1000);
                else if (originDigit == 900) digitToRoman(900);
                else if (originDigit < 900 && originDigit >= 500) digitToRoman(digit, 100, 500);
                else if (originDigit == 400) digitToRoman(400);
                else if (originDigit < 400 && originDigit >= 100) digitToRoman(digit, 100);
                else if (originDigit == 90) digitToRoman(90);
                else if (originDigit < 90 && originDigit >= 50) digitToRoman(digit, 10, 50);
                else if (originDigit == 40) digitToRoman(40);
                else if (originDigit < 40 && originDigit >= 10) digitToRoman(digit,10);
                else if (originDigit == 9) digitToRoman(9);
                else if (originDigit < 9 && originDigit >= 5) digitToRoman(digit, 1, 5);
                else if (originDigit == 4) digitToRoman(4);
                else if (originDigit < 4) digitToRoman(digit, 1);
            }
        }

        return res.toString();
    }

    public void digitToRoman(int digit, int key1){
        while (digit > 0){
            res.append(hm.get(key1));
            digit--;
        }
    }

    public void digitToRoman(int digit, int key1, int key2){
        digit -= 5;
        res.append(hm.get(key2));
        while (digit > 0){
            res.append(hm.get(key1));
            digit--;
        }
    }

    public void digitToRoman(int key1){
        res.append(hm.get(key1));
    }

    static public void main(String [] args){
        Problem12 p = new Problem12();
        System.out.println(p.intToRoman(1994));
    }
}
