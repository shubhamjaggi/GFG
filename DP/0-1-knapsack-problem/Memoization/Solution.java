
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n){
        int[][] dp = new int[W+1][n];
        java.util.stream.IntStream.rangeClosed(0, W).forEach(a -> Arrays.fill(dp[a], -1));
        return ans(W, wt, val, n-1, dp);
    }
    
    private static int ans(int capacity, int wt[], int val[], int i, int[][] dp){
        if(i==0){
            return wt[0]<=capacity?val[0]:0;
        }
        if(dp[capacity][i]!=-1) return dp[capacity][i];
        int ans1=0;
        if (wt[i]<=capacity) ans1 = val[i] + ans(capacity-wt[i], wt, val, i-1, dp);
        int ans2 = 0 + ans(capacity, wt, val, i-1, dp);
        return dp[capacity][i] = Math.max(ans1, ans2);
    }
}
