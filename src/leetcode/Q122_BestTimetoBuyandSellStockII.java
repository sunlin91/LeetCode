package leetcode;

/**
 * Created by SUN on 2018/5/13
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class Q122_BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int res = 0, cur, i;
        i = findNextBuyDate(prices, 0);
        cur = prices[i];
        while (i < prices.length) {
            if (prices[i] > cur) {
                res += prices[i] - cur;
                i = findNextBuyDate(prices, i);
                cur = prices[i];
            } else
                i++;
        }
        return res;
    }

    int findNextBuyDate(int[] prices, int start) {
        int i = start;
        for (; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                break;
            }
        }
        return i;
    }
}
