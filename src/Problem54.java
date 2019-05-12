import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        if (n == 0) {
            return ans;
        }
        int m = matrix[0].length;
        int rightBorder = m - 1, bottomBorder = n - 1, leftBorder = 0, topBorder = 0;
        while (rightBorder >= leftBorder || topBorder <= bottomBorder) {
            if (leftBorder <= rightBorder) {
                for (int i = leftBorder; i <= rightBorder; i++) ans.add(matrix[topBorder][i]);
                topBorder++;
            } else return ans;
            if (topBorder <= bottomBorder) {
                for (int i = topBorder; i <= bottomBorder; i++) ans.add(matrix[i][rightBorder]);
                rightBorder--;
            } else return ans;
            if (leftBorder <= rightBorder) {
                for (int i = rightBorder; i >= leftBorder; i--) ans.add(matrix[bottomBorder][i]);
                bottomBorder--;
            } else return ans;
            if (topBorder <= bottomBorder) {
                for (int i = bottomBorder; i >= topBorder; i--) ans.add(matrix[i][leftBorder]);
                leftBorder++;
            } else return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem54 p = new Problem54();
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(p.spiralOrder(a));
    }
}
