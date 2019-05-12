package UpTo50;

public class Problem6 {
    private String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int len = s.length();
        if (len == 0){
            String rts = "";
            return rts;
        }
        int column = numRows - 1;
        if (len > numRows * 2 - 2){
            column = ((len / (numRows * 2 - 2)) + 1) * (numRows - 1);
        }
        char m[][] = new char[numRows][column];
        char s0[] = s.toCharArray();
        int nr = 0, nc = 0, flag = 0;
        for (char c: s0){
            m[nr][nc] = c;
            switch (flag){
                case 1:
                    if (nr == 0){
                        flag = 0;
                        nr++;
                        break;
                    }
                    nr--;
                    nc++;
                    break;
                case 0:
                    if ((nr + 1) == numRows){
                        flag = 1;
                        nr--;
                        nc++;
                        break;
                    }
                    nr++;
                    break;
            }
        }
        char rt[] = new char[len];
        int i = 0;
        for (char ch[]: m){
            for (char c:ch) {
                if (c != '\u0000') {
                    rt[i++] = c;
                }
            }
        }
        String rts = new String(rt);
        return rts;
    }
    private String convert2(String s, int numRows){
        if (numRows == 1){
            return s;
        }
        int len = s.length();
        if (len == 0){
            String rts = "";
            return rts;
        }
        int numset = numRows * 2 - 2;
        int column = (len / numset + 1) * 2;
        char m[][] = new char[numRows][column];
        char s0[] = s.toCharArray();
        int count[] = new int[numRows];
        int index;
        char c;
        for (int i = 0; i < len; i++){
            c = s.charAt(i);
            index = i % numset;
            if (index < numRows){
                m[index][count[index]++] = c;
            }
            else {
                index = numset - index;
                m[index][count[index]++] = c;
            }
        }
        char rt[] = new char[len];
        int i = 0;
        for (char ch[]: m){
            for (char a:ch) {
                if (a != '\u0000') {
                    rt[i++] = a;
                }
            }
        }
        String rts = new String(rt);
        return rts;
    }
    private String convert3(String s, int numRows){
        int len = s.length();
        if (len < numRows || numRows == 1){
            return s;
        }
        char rt[] = new char[len];
        int step = numRows * 2 - 2;
        int count = 0;
        for (int i = 0; i < numRows; i++){
            int interval = step - 2 * i;
            for (int j = i; j < len; j += step){
                rt[count++] = s.charAt(j);
                if (interval > 0 && count < len && interval + j < len && step > interval){
                    rt[count++] = s.charAt(j + interval);
                }
            }
        }
        return new String(rt);
    }
    public static void main(String[] args){
        String s = "ABC";
        int numRow = 3;
        Problem6 s1 = new Problem6();
        System.out.println(s1.convert3(s, numRow));
    }
}
