import java.util.ArrayList;
import java.util.List;

public class Problem65 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        boolean flag1 = isPureNumber(s) || isENumber(s) || isDotNumber(s) || isSignNumber(s);
        return flag1;
    }

    private boolean isPureNumber(String s) {
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' > 9 || s.charAt(i) - '0' < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isDotNumber(String s) {
        if (s.length() < 2) return false;
        int dotIndex = s.indexOf('.');
        if (dotIndex == -1) return false;
        boolean flag2 = dotIndex == s.length() - 1 && isSignNumber(s.substring(0, dotIndex)); // 4.
        if (flag2) return true;
        boolean flag3 = dotIndex == 0 && isPureNumber(s.substring(1)); // 5.
        if (flag3) return true;
        boolean flag1 = isSignNumber(s.substring(0, dotIndex)) && isPureNumber(s.substring(dotIndex + 1)); // +2.3
        return flag1;
    }

    private boolean isSignNumber(String s) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.length() < 2) return false;
            if (!(isPureNumber(s.substring(1)) || isDotNumber(s.substring(1)))) return false;
        } else {
            if (!(isPureNumber(s) || isDotNumber(s))) return false;
        }
        return true;
    }

    private boolean isENumber(String s) {
        if (s.length() < 3) return false;
        int eIndex = s.indexOf('e');
        if (eIndex == -1) return false;
        boolean flag1 = isSignNumber(s.substring(0, eIndex)) && (isSignNumber(s.substring(eIndex + 1)) && !isDotNumber(s.substring(eIndex + 2)) && !isDotNumber(s.substring(eIndex + 1))); // 3e5
        boolean flag2 = isDotNumber(s.substring(0, eIndex)) && (isSignNumber(s.substring(eIndex + 1)) && !isDotNumber(s.substring(eIndex + 2)) && !isDotNumber(s.substring(eIndex + 1))); // 2.5e8
        return flag1 || flag2;
    }

    public static void main(String[] args) {
        Problem65 p = new Problem65();
        List<String> a = new ArrayList<>();
        a.add("4e3.");
        a.add("+.8");
        a.add("..");
        a.add("0");
        a.add("0.1");
        a.add("abc");
        a.add("1 a");
        a.add("2e10");
        a.add("-90e3    ");
        a.add(" 1e");
        a.add("e3");
        a.add("6e-1");
        a.add("99e2.5");
        a.add("53.5e93");
        a.add("--6");
        a.add("-+3");
        a.add("95a54e53");
        for (String s : a) {
            System.out.println(s);
            System.out.println(p.isNumber(s));
            System.out.println();
        }
    }
}
