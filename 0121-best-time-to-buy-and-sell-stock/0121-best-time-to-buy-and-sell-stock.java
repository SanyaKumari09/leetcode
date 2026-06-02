class Solution{
    public int maxProfit(int[] prices) {
        int bestBuy=prices[0];
        int prof=0;
        int n=prices.length;
        //Consider each day as selling day and check 
        for(int i=0;i<n;i++) {
            if(prices[i]>bestBuy){
                prof=Math.max(prof, prices[i]-bestBuy);
            }
            bestBuy=Math.min(prices[i],bestBuy);
        }
        return prof;
    }
}

















