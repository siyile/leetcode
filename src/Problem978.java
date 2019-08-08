public class Problem978 {
    public static void main(String[] args) {
        Problem978 p = new Problem978();

        System.out.println(p.maxTurbulenceSize(new int[]{9}));
    }

    public int maxTurbulenceSize(int[] A) {
        int cnt1 = 1, cnt2 = 1;
        int cnt = 0;
        for (int i = 1; i < A.length; i++) {
            cnt1 = A[i - 1] > A[i] ? cnt1 + 1 : 1;
            cnt = Math.max(cnt1, cnt);
            cnt2 = A[i - 1] < A[i] ? cnt2 + 1 : 1;
            cnt = Math.max(cnt2, cnt);

            int tmp = cnt1;
            cnt1 = cnt2;
            cnt2 = tmp;
        }
        return cnt;
    }
}
