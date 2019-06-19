package Contest;

public class Problem1090 {
    private void sort(int[] a, int[] b, int l, int r) {
        if (l >= r) return;
        int start = l;
        int end = r;
        int x = a[l];
        int y = b[l];
        while(l < r) {
            while(l < r && a[r] <= x) {
                r--;
            }
            if (l < r) {
                a[l] = a[r];
                b[l] = b[r];
                l++;
            }
            while (l < r && a[l] >= x) {
                l++;
            }
            if (l < r) {
                a[r] = a[l];
                b[r] = b[l];
                r--;
            }
        }
        a[l] = x;
        b[l] = y;
        sort(a, b, start, l - 1);
        sort(a, b, l + 1, end);
    }

    public static void main(String[] args) {
        Problem1090 p = new Problem1090();
        int [] a= {5,6,2,3,4,6,1,4,5,6,7,8,1,2,0,0};
        int [] b= {1,2,3,4,5,6,7,4,5,6,7,8,1,2,0,0};
        p.sort(a, b, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
