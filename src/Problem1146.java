import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Problem1146 {
    class SnapshotArray {
        List<TreeMap<Integer, Integer>> store;
        int snap_id;

        public SnapshotArray(int length) {
            store = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                store.add(new TreeMap<>());
                store.get(i).put(0, 0);
            }
        }

        public void set(int index, int val) {
            store.get(index).put(snap_id, val);
        }

        public int snap() {
            return snap_id++;
        }

        public int get(int index, int snap_id) {
            return store.get(index).floorEntry(snap_id).getValue();
        }
    }

}
