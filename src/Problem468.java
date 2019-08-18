public class Problem468 {
    String NEITHER = "Neither";
    String IPV4 = "IPv4";
    String IPV6 = "IPv6";

    public static void main(String[] args) {
        Problem468 p = new Problem468();

        System.out.println(p.validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334"));
    }

    public String validIPAddress(String ip) {
        boolean exist4 = ip.indexOf('.') >= 0;
        boolean exist6 = ip.indexOf(':') >= 0;
        if (exist4 == exist6) return NEITHER;
        if (exist4) {
            if (ip.endsWith(".")) return NEITHER;
            String[] split = ip.split("\\.");
            if (split.length != 4) return NEITHER;
            for (String str :
                    split) {
                if (!check4(str)) return NEITHER;
            }
            return IPV4;
        } else {
            if (ip.endsWith(":")) return NEITHER;
            String[] split = ip.split(":");
            if (split.length != 8) return NEITHER;
            for (String str :
                    split) {
                if (!check6(str)) return NEITHER;
            }
            return IPV6;
        }
    }

    private boolean check4(String str) {
        if (str.length() > 3 || str.isEmpty()) return false;
        char[] chs = str.toCharArray();
        for (char ch :
                chs) {
            if (ch < '0' || ch > '9') return false;
        }
        int v = Integer.parseInt(str);
        if (v >= 0 && v <= 255)
            if (v != 0 && str.startsWith("0") || v == 0 && str.length() > 1)
                return false;
            else return true;
        else return false;
    }

    private boolean check6(String str) {
        if (str.length() > 4 || str.isEmpty()) return false;
        str = str.toLowerCase();
        char[] chs = str.toCharArray();
        for (char ch :
                chs) {
            if (!(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'f'))
                return false;
        }
        return true;
    }
}
