
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n){
        return ans(W, wt, val, n-1);
    }
    
    private static int ans(int capacity, int wt[], int val[], int index){
        int[][] dp = new int[capacity+1][index+1];
        for(int c=0; c<=capacity; c++){
            for(int i=0; i<=index; i++){
                if(i==0){
                    dp[c][i] = wt[0]<=c?val[0]:0;
                    continue;
                }
                int ans1=0;
                if (wt[i]<=c) ans1 = val[i] + dp[c-wt[i]][i-1];
                int ans2 = 0 + dp[c][i-1];
                dp[c][i] = Math.max(ans1, ans2);
            }
        }
        return dp[capacity][index];
    }
}
