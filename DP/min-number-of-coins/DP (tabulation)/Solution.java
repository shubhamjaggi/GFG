
//User function Template for Java

class Solution
{
    public int MinCoin(int[] nums, int amount){
        int ans = getMinNumberOfCoins(nums, amount);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    
    private int getMinNumberOfCoins(int[] coins, int amount){
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        
        for(int i=1; i<=amount; i++){
            for(int coinVal : coins){
                if(i>=coinVal){
                    int remAmount = i-coinVal;
                    dp[i] = (dp[remAmount]!=Integer.MAX_VALUE && (1+dp[remAmount])<dp[i])?(1+dp[remAmount]):dp[i];
                }
            }
        }
        
        return dp[amount];
    }
}