import java.util.List;

public class Problem364 {
    interface NestedInteger {
        public Integer getInteger();
        public void setInteger(int value);
        public void add(NestedInteger ni);
        public List<NestedInteger> getList();
        public boolean isInteger();
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int d = 0;
        for (NestedInteger ni :
                nestedList) {
            d = Math.max(d, depth(ni, 1));
        }
        int ans = 0;
        for (NestedInteger ni :
                nestedList) {
            ans += sum(ni, d);
        }
        return ans;
    }

    private int sum(NestedInteger ni, int d) {
        if (ni.isInteger()) {
            return d * ni.getInteger();
        } else {
            int ans = 0;
            for (NestedInteger n :
                    ni.getList()) {
                ans += sum(n, d - 1);
            }
            return ans;
        }
    }

    private int depth(NestedInteger ni, int d) {
        if (ni.isInteger()) {
            return d;
        } else {
            int d1 = d;
            for (NestedInteger n :
                    ni.getList()) {
                d1 = Math.max(d1, depth(n, d + 1));
            }
            return d1;
        }
    }
}
