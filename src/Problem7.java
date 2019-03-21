public class Problem7 {
    static int max = (int) ((long) Math.pow(2, 31) - 1);
    static int min = -max - 1;
    public String deleteZero(StringBuffer str){
        while (str.charAt(0) == '0' && str.length() > 9){
            str.delete(0, 1);
        }
        return str.toString();
    }
    private int processDigit(StringBuffer str, boolean sign){
        String s = deleteZero(str);
        if (s.length() > 12){
            if (sign){
                return max;
            }
            else {
                return min;
            }
        }
        System.out.println(s + sign);
        long a = Long.parseLong(s);
        if (!sign){
            a *= -1;
        }
        if (a > max && sign){
            return (int) max;
        }
        if (a < min && !sign){
            return (int) min;
        }
        return (int) a;
    }

    public int myAtoi(String str){
        char[] string = str.toCharArray();
        boolean positive = false;
        boolean negative = false;
        boolean sign = true;
        boolean digitStart = false;
        boolean signStart = false;
        StringBuffer digit = new StringBuffer();
        for (char c:string){
            if ((c != '+' && c != '-' && !Character.isDigit(c) && c != ' ') && !digitStart) {
                break;
            }
            if (!Character.isDigit(c) && signStart){
                break;
            }
            if ((!Character.isDigit(c) || (c == '+' || c == '-')) && digitStart){
                break;
            }
            if (c == '+'){
                sign = true;
                positive = true;
                signStart = true;
            }
            if (c == '-'){
                sign = false;
                negative = true;
                signStart = true;
            }
            if (Character.isDigit(c)){
                digitStart = true;
                digit.append(c);
            }
        }
        if (!digitStart){
            return 0;
        }
        if (positive && negative){
            return 0;
        }
        if (digit.length() == 0){
            return 0;
        }
        return processDigit(digit, sign);
    }

    public int myAtoi2(String str) {
        char[] strArr = str.toCharArray();
        char[] intArr = new char[strArr.length];
        int intArrIndex = 0;

        boolean invalidSpace = false;
        boolean negative = false;
        boolean ignoreableZero = true;

        for(int i=0; i<strArr.length; i++){

            if(strArr[i]==' ' && !invalidSpace)
                continue;

            if(strArr[i]=='-' && !invalidSpace){
                negative = true;
                invalidSpace = true;
                continue;
            }

            if(strArr[i]=='+' && !invalidSpace){
                invalidSpace = true;
                continue;
            }

            if(strArr[i]=='0' && ignoreableZero){
                invalidSpace = true;
                continue;
            }

            if(strArr[i]>='0'&&strArr[i]<='9'){
                ignoreableZero = false;
                invalidSpace = true;
                intArr[intArrIndex] = strArr[i];
                intArrIndex++;
                continue;
            }

            break;
        }

        int value = 0;
        int multiplerBase = 1;

        for(int i=intArrIndex-1; i>=0; i--){

            int multiplerValue = (intArr[i] - '0');
            int multipler = multiplerValue * multiplerBase;

            if(multipler/multiplerBase!=multiplerValue){
                if(negative){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }

            value = value + multipler;

            int newMultiplerBase = multiplerBase * 10;

            if(i>0 && newMultiplerBase/10 != multiplerBase){
                if(negative){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }

            multiplerBase = newMultiplerBase;

            if(value < 0){
                if(negative){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
        }

        if(negative){
            return value * -1;
        }else
            return value;

    }
    public static void main(String[] args){
        Problem7 p = new Problem7();
        System.out.println(p.myAtoi2("  "));
    }
}
