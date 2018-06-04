package leetcode;

/**
 * Created by SunLin on 2018.6.4
 * <p>
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
 * from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1.
 * <p>
 * Note:
 * <p>
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * Example 1:
 * <p>
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * Example 2:
 * <p>
 * Input:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * Output: -1
 * <p>
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 */
public class Q134_GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    //找到和最小的位置
    //如果小于0则返回-1不存在
    //如果存在，则是该位置的的下一个位置（i+1），因为要返回该位置（因为题目说唯一）
    //思路真是绝了，（耗时1ms，我的是129ms。。。）
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, start_idx = 0, min_sum = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; ++i) {
            sum += gas[i] - cost[i];
            if (sum < min_sum) {
                min_sum = sum;
                start_idx = (i + 1) % gas.length;
            }
        }
        if (sum < 0)
            return -1;
        else
            return start_idx;
    }

    //Time Limit Exceeded
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int sum=0;
//        for (int i=0;i<gas.length;i++){
//            sum+=gas[i]-cost[i];
//        }
//        if (sum<0)
//            return -1;//加了sum后通过了，但是时间还是很长(129ms)
//        for (int i=0;i<gas.length;i++){
//            int total=0;
//            boolean flag=true;
//            for (int j=0;j<gas.length;j++){//start=i+j
//                int next = (i+j)%gas.length;
//                total+=gas[next];
//                if (total<cost[next]) {
//                    flag=false;
//                    break;
//                }
//                total-=cost[next];
//            }
//            if (flag)
//                return i;
//        }
//        return -1;
//    }
}
