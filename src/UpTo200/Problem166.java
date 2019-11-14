package UpTo200;

import java.util.ArrayList;
import java.util.List;

public class Problem166 {
    public static void main(String[] args) {
        Problem166 p = new Problem166();

        System.out.println(p.fractionToDecimal(2, 3));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        boolean negative = (numerator > 0) ^ (denominator > 0);
        if (numerator == 0) return "0";
        long num = numerator;
        long denom = denominator;
        num = Math.abs(num);
        denom = Math.abs(denom);
        List<Long> remainders = new ArrayList<>();
        List<Long> quotients = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        if (negative) sb.append('-');

        sb.append(num / denom);
        long remainder = num % denom;

        if (remainder == 0) {
            return sb.toString();
        } else {
            while (!remainders.contains(remainder) && remainder != 0) {
                remainders.add(remainder);
                quotients.add((remainder * 10 / denom));
                remainder = (remainder * 10 % denom);
            }
            sb.append(".");
            if (remainder == 0) {
                for (Long x :
                        quotients) {
                    sb.append(x);
                }
                return sb.toString();
            } else {
                int i;
                for (i = 0; i < remainders.size(); i++) {
                    if (remainders.get(i) != remainder) {
                        sb.append(quotients.get(i));
                    } else {
                        break;
                    }
                }
                sb.append('(');
                while (i < quotients.size()) {
                    sb.append(quotients.get(i++));
                }
                sb.append(')');
                return sb.toString();
            }
        }
    }
}
