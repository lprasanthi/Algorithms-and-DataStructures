// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3287/
public class BestTimeToBuySell {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int sum =0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] - prices[i-1] > 0){
                sum = sum + prices[i] - prices[i-1];
            }
        }
        return sum;
    } 
}