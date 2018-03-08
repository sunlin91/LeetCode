package leetcode;

/**
 * Created by SUN on 2017.11.29.
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.
 */
public class U_Q011_ContainerWithMostWater {
    //贪心思想
    public int maxArea(int[] height) {
        if(height==null||height.length==0)
            return 0;
        int maxA=0,tmp=0;
        int left=0,right=height.length-1;
        while (left<right){
            tmp=(right-left)*(height[right]<height[left]?height[right]:height[left]);
            maxA=(maxA>tmp?maxA:tmp);
            if(height[left]>height[right])
                right--;
            else
                left++;
        }
        return maxA;
    }
}
