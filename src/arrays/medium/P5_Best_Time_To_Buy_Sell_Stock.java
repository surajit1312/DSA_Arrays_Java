package arrays.medium;

/**
 * 
 * CodingNinjas: Best time to buy and sell stock
 * Link:
 * https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_6194560
 * 
 * TC: O(N)
 * SC: O(1)
 * 
 */
public class P5_Best_Time_To_Buy_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 4, 3, 6 };
        int maxProfit = bestTimeToBuyAndSellStock(prices);
        System.out.println("Maximum profit gained by buying and selling stocks : " + maxProfit);
    }

    private static int bestTimeToBuyAndSellStock(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        int currentProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            currentProfit = prices[i] - min;
            if (maxProfit < currentProfit) {
                maxProfit = currentProfit;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
