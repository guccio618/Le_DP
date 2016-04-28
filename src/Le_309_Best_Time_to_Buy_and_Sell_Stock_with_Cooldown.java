
public class Le_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        } else if(prices.length == 2){
            return Math.max(0, prices[1] - prices[0]);
        }
        
        int n = prices.length;
        int[] sell = new int[n];   // 当天不持股时的最大获利
        int[] buy = new int[n];    // 当天持股时的最大获利
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(0, prices[1] - prices[0]);
        
        for(int i = 2; i < n; i++){
            sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]);  // 当天不持股=昨天不持股或昨天买，今天卖
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);   // 当天持股=昨天持股或前天卖出，今天买入
        }
        
        return sell[n - 1];
    }
}
