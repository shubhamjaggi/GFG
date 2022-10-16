
//User function Template for Java

class Solution
{
    public int MinCoin(int[] nums, int amount){
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        int ans = getMinNumberOfCoins(nums, amount, dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    
    private int getMinNumberOfCoins(int[] coins, int amount, Map<Integer, Integer> dp){
        if(dp.containsKey(amount)){
            return dp.get(amount);
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int coinVal : coins){
            if(coinVal<=amount){
                int temp = getMinNumberOfCoins(coins, amount-coinVal, dp);
                res = (temp!=Integer.MAX_VALUE && (1+temp)<res)?(1+temp):res;
            }
        }
        
        dp.put(amount, res);
        return res;
    }
}