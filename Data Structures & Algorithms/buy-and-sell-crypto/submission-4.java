class Solution {
    public int maxProfit(int[] prices) {
        int l=0,r=1;
        int maxProfit = 0;
        for(int i=0;i<prices.length-1;i++){
            int profit = 0;
            if(prices[l] > prices[r]){
                l =r;
                r++;
                continue;
            }
            if(prices[l] <= prices[r]){
                profit = prices[r] - prices[l];
                r++;
            }
            maxProfit = Integer.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
