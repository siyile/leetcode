package UpTo200;

public class Problem165 {
    public static void main(String[] args) {
        Problem165 p = new Problem165();

        System.out.println(p.compareVersion("1.0.1", "1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < v1.length && j < v2.length) {
            int comp = Integer.compare(Integer.parseInt(v1[i++]), Integer.parseInt(v2[j++]));
            if (comp != 0) {
                return comp;
            }
        }

        if (i == v1.length) {
            while (j < v2.length) {
                if (Integer.parseInt(v2[j++]) > 0) return -1;
            }
            return 0;
        }
        if (j == v2.length) {
            while (i < v1.length) {
                if (Integer.parseInt(v1[i++]) > 0) return 1;
            }
            return 0;
        }
        return 0;
    }
}
