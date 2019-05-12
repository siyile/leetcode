package UpTo50;

public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        int arrayLen = strs.length;
        if (arrayLen == 0){
            return "";
        }
        if (arrayLen == 1){
            return strs[0];
        }
        int minLen = 99999;
        for (String str : strs) {
            if (str.length() == 0){
                return "";
            }
            minLen = minLen < str.length() ? minLen : str.length();
        }
        boolean flag = true;
        while (i < minLen && flag){
            char c = strs[0].charAt(i);
            for (int j = 1; j < arrayLen; j++){
                if (strs[j].charAt(i) != c){
                    flag = false;
                    break;
                }
            }
            i = flag? i + 1 : i;
        }
        return strs[0].substring(0, i);
    }
    public static void main(String[] args){
        Problem14 p = new Problem14();
        String[] strs = {"ssaa","ffa","fad"};
        System.out.println(p.longestCommonPrefix(strs));
    }
}
