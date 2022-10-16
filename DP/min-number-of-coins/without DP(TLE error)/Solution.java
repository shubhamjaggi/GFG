
//User function Template for Java

class Solution
{
    public int MinCoin(int[] nums, int amount){
        int ans = getMinNumberOfCoins(nums, amount);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    
    private int getMinNumberOfCoins(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int coinVal : coins){
            if(coinVal<=amount){
                int temp = getMinNumberOfCoins(coins, amount-coinVal);
                res = (temp!=Integer.MAX_VALUE && (1+temp)<res)?(1+temp):res;
            }
        }
        
        return res;
    }
}