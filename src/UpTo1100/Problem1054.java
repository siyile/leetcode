package UpTo1100;

import java.util.HashMap;
import java.util.Map;

public class Problem1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[barcodes.length];
        int maxNum = 0, freCode = -1;
        for (int code :
                barcodes) {
            int cnt = map.getOrDefault(code, 0) + 1;
            map.put(code, cnt);
            if (maxNum < cnt) {
                maxNum = cnt;
                freCode = code;
            }

        }
        int idx = 0;
        for (int i = 0; i < maxNum; i++, idx += 2) {
            ans[idx] = freCode;
        }
        map.remove(freCode);
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                idx = idx > ans.length ? 1 : idx;
                ans[idx] = entry.getKey();
            }
        }
        return ans;
    }
}
