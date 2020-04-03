import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Problem385 {
    private interface NestInteger {
        public Integer getInteger();
        public void setInteger(int value);
        public void add(NestedInteger ni);
        public List<NestedInteger> getList();
        public boolean isInteger();
    }

    class NestedInteger implements NestInteger {

        public NestedInteger(int value) {

        }

        public NestedInteger() {

        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public void setInteger(int value) {

        }

        @Override
        public void add(NestedInteger ni) {

        }

        @Override
        public List<NestedInteger> getList() {
            return null;
        }

        @Override
        public boolean isInteger() {
            return false;
        }
    }

    public NestedInteger deserialize(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        int l = 0;
        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger curr = null;
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r + 1;
            } else if (s.charAt(r) == ']') {
                if (r != l) {
                    curr.add(new NestedInteger(Integer.parseInt(s.substring(l, r))));
                }
                if (!stack.isEmpty()) {
                    NestedInteger prev = stack.pop();
                    prev.add(curr);
                    curr = prev;
                }
                l = r + 1;
            } else if (s.charAt(r) == ',') {
                if (s.charAt(r - 1) != ']') {
                    curr.add(new NestedInteger(Integer.parseInt(s.substring(l, r))));
                }
                l = r + 1;
            }
        }
        return curr;
    }
}
