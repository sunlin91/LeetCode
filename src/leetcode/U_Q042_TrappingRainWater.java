package leetcode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
/**
 * Created by SUN on 2018/2/4
 */
public class U_Q042_TrappingRainWater {
    //方法3 Using stacks [Accepted]
    public int trap(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> st=new Stack<>();
        while (current < height.length) {
            //若当前的高度比栈顶小则入栈，否则与栈顶元素进行比较运算
            //栈中元素，小的在栈顶
            //从小到大，一次计算围成长方形的面积
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = (height[current]<height[st.peek()]
                        ?height[current]:height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }

    //方法2 Dynamic Programming [Accepted]
//    public int trap(int[] height) {
//        if (height == null||height.length==0)
//            return 0;
//        int ans = 0;
//        int size = height.length;
//        int[] left_max = new int[size];
//        int[] right_max = new int[size];
//        left_max[0] = height[0];
//        for (int i = 1; i < size; i++) {
//            left_max[i] = (height[i] > left_max[i - 1] ? height[i] : left_max[i - 1]);
//        }
//        right_max[size - 1] = height[size - 1];
//        for (int i = size - 2; i >= 0; i--) {
//            right_max[i] = (height[i] > right_max[i + 1] ? height[i] : right_max[i + 1]);
//        }
//        for (int i = 1; i < size - 1; i++) {
//            ans += (left_max[i] < right_max[i] ? left_max[i] : right_max[i]) - height[i];
//        }
//        return ans;
//    }


    //方法1 Brute force [Accepted]
    //找最大的左边和右边
//    public int trap(int[] height) {
//        int ans=0;
//        int size=height.length;
//        for (int i = 1; i < size - 1; i++) {
//            int max_left = 0, max_right = 0;
//            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
//                max_left =(max_left>height[j]?max_left:height[j]);
//            }
//            for (int j = i; j < size; j++) { //Search the right part for max bar size
//                max_right = (max_right>height[j]?max_right:height[j]);
//            }
//            ans += (max_left<max_right?max_left:max_right) - height[i];
//        }
//        return ans;
//    }


    //time limit...
//    public int trap(int[] height) {
//        if (height == null || height.length <= 0)
//            return 0;
//        int maxHeight = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] > maxHeight) {
//                maxHeight = height[i];
//            }
//        }
//        int total = 0;
//        int current = 0;
//        for (int i = 1; i <= maxHeight; i++) {
//            boolean flag = false;//第一次出现墙壁
//            current = 0;
//            for (int j = 0; j < height.length; j++) {
//                //墙壁没有当前高度高
//                if (height[j] < i && flag == true) {
//                    current++;
//                    continue;
//                }
//                if (height[j] >= i) {//墙壁比当前高度高或相等
//                    if (flag == false) {
//                        flag = true;
//                        continue;
//                    }
//                    total += current;
//                    current=0;
//                }
//            }
//        }
//        return total;
//    }
}
