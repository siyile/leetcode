import java.util.Iterator;
import java.util.List;

public class Problem281 {
    private class ZigzagIterator {

        Iterator<Integer> i1;
        Iterator<Integer> i2;
        int turn = 1;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            i1 = v1.iterator();
            i2 = v2.iterator();
        }

        public int next() {
            if (turn == 1) {
                turn = 2;
                if (i1.hasNext()) {
                    return i1.next();
                }
            } else {
                turn = 1;
                if (i2.hasNext()) {
                    return i2.next();
                }
            }
            return next();
        }

        public boolean hasNext() {
            return i1.hasNext() && i2.hasNext();
        }
    }
}
