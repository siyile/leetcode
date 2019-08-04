import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray {
    int n;
    List<Integer> arr;
    List<List<Integer>> snap;
    int row = 0;
    int col = 0;
    int count;

    List<List<Integer>> idx;
    List<List<Integer>> value;
    Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();

    public SnapshotArray(int length) {
        n = length;
        arr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arr.add(0);
        }
        idx = new ArrayList<>();
        value = new ArrayList<>();
        idx.add(new ArrayList<>());
        value.add(new ArrayList<>());
    }

    public void set(int index, int val) {
        idx.get(row).add(index);
        value.get(row).add(val);
        col++;
    }

    public int snap() {
        idx.get(row).add(-1);
        value.get(row).add(0);
        col++;
        map.put(count, new Pair<>(row, col));
        if (col == n) {
            List<Integer> index = idx.get(row);
            List<Integer> v = value.get(row);
            List<Integer> tmp = new ArrayList<>(snap.get(snap.size() - 1));
            for (int i = 0; i < col; i++) {
                tmp.set(index.get(i), v.get(i));
            }
            snap.add(tmp);

            col = 0;
            row++;
            idx.add(new ArrayList<>());
            value.add(new ArrayList<>());
        }
        return count++;
    }

    public int get(int t, int snap_id) {
        int row = map.get(snap_id).getKey();
        int col = map.get(snap_id).getValue();

        List<Integer> index = idx.get(row);
        List<Integer> v = value.get(row);
        List<Integer> tmp = new ArrayList<>(row);
        for (int i = 0; i < col; i++) {
            tmp.set(index.get(i), v.get(i));
        }
        return tmp.get(t);
    }
}
