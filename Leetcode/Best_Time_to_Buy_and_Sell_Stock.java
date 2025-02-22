public class Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
            profit = Math.max(profit, prices[i] - buyPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock app = new Best_Time_to_Buy_and_Sell_Stock();
        System.out.println(app.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
