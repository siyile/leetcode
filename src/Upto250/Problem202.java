package Upto250;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem202 {
    public static void main(String[] args) {
        Problem202 p = new Problem202();

        System.out.println(p.isHappy(123));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = cal(n);
            if (set.add(n)) return false;
        }

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(0);
        l.remove(1);
        System.out.println(l);
        return true;
    }

    private int cal(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
