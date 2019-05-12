package UpTo50;

public class Problem11 {
    public int maxArea(int[] height) {
        int maxAreaValue = -1;
        int i = 0, j = height.length - 1;
        while (i != j){
            int currentArea = Math.min(height[i], height[j]) * (j - i);
            maxAreaValue = currentArea>maxAreaValue?currentArea:maxAreaValue;
            if (height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxAreaValue;
    }

    public static void main(String [] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        Problem11 p = new Problem11();
        System.out.println(p.maxArea(height));
    }
}
