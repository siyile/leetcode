public class Problem393 {
    public boolean validUtf8(int[] data) {
        int j = 0;
        while (j < data.length) {
            if ((data[j] & 1 << 7) == 0) {
                j++;
                continue;
            }

            int cnt = 0;
            for (int i = 7; i >= 5; i--) {
                int b = data[j];
                if ((b & 1 << i) != 0) {
                    cnt += 1;
                } else {
                    break;
                }
            }

            if (cnt == 1 || j + cnt > data.length || ((data[j] & 1 << 7 - cnt) != 0)) {
                return false;
            }

            for (int i = 1; i < cnt; i++) {
                int b = data[i + j];
                if ((b & 1 << 6) != 0 || (b & 1 << 7) == 0) {
                    return false;
                }
            }

            j += cnt;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem393 p = new Problem393();

        System.out.println(p.validUtf8(new int[]{197, 130, 1}));
    }
}
