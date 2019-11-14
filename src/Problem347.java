import java.util.*;

public class Problem347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n :
                nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> l = new ArrayList<>(map.values());

        int min = quickSelect(l, k - 1);

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() >= min)
                ans.add(entry.getKey());
        }

        return ans;
    }

    private int quickSelect(List<Integer> list, int k) {
        int l = 0, r = list.size() - 1;
        while (true) {
            int pivot = list.get(r);
            int i = l;
            for (int j = l; j < r; j++) {
                if (list.get(j) > pivot)
                    swap(i++, j, list);
            }
            swap(r, i, list);

            if (i > k) {
                r = i - 1;
            } else if (i < k){
                l = i + 1;
            } else {
                return pivot;
            }
        }
    }

    private void swap(int i, int j, List<Integer> l) {
        int tmp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, tmp);
    }

    public static void main(String[] args) {
        Problem347 p = new Problem347();

        System.out.println(p.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
}
