import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<>();

        if (n == 0) return output;
        if (n == 1) {
            int[] b = buildings[0];
            output.add(Arrays.asList(b[0], b[2]));
            output.add(Arrays.asList(b[1], 0));
            return output;
        }

        List<List<Integer>> left = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
        List<List<Integer>> right = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));

        return merge(left, right);

    }

    private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> output = new ArrayList<>();
        int nl = left.size(), nr = right.size();
        int currY = 0, leftY = 0, rightY = 0, pl = 0, pr = 0, x, maxY;
        while (pl < nl && pr < nr) {
            List<Integer> pointL = left.get(pl);
            List<Integer> pointR = right.get(pr);
            if (pointL.get(0) < pointR.get(0)) {
                x = pointL.get(0);
                leftY = pointL.get(1);
                pl++;
            } else {
                x = pointR.get(0);
                rightY = pointR.get(1);
                pr++;
            }

            maxY = Math.max(leftY, rightY);

            if (currY != maxY) {
                currY = maxY;
                update(output, x, currY);
            }

        }

        appendRest(output, left, pl, currY);
        appendRest(output, right, pr, currY);

        return output;
    }

    private void update(List<List<Integer>> output, int x, int y) {
        if (output.isEmpty() || output.get(output.size() - 1).get(0) != x) {
            output.add(Arrays.asList(x, y));
        } else {
            output.get(output.size() - 1).set(1, y);
        }
    }

    ;

    private void appendRest(List<List<Integer>> output, List<List<Integer>> skylines, int p, int currY) {
        for (int i = p; i < skylines.size(); i++) {
            List<Integer> b = skylines.get(i);
            int x = b.get(0), y = b.get(1);

            if (currY != y) {
                update(output, x, y);
                currY = y;
            }
        }
    }
}
