import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Problem341 {
     // This is the interface that allows for creating nested lists.
     // You should not implement it, or speculate about its implementation
     public interface NestedInteger {
         // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();
         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();
         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
     }
    public class NestedIterator implements Iterator<Integer> {

        Deque<NestedInteger> s = new ArrayDeque<>();
        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                s.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return s.poll().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!s.isEmpty()) {
                if (s.peek().isInteger())
                    return true;
                List<NestedInteger> niList = s.pop().getList();
                for (int i = niList.size() - 1; i >= 0; i--) {
                    s.push(niList.get(i));
                }
            }
            return false;
        }
    }

}
