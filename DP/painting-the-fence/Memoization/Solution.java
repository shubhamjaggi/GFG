

class Solution
{
    long countWays(int n,int k){
        //f(n, k) = same(n, k) + diff(n, k)
        //same(n, k) : number of ways in which last 2 blocks have same color
        //diff(n, k) : number of ways in which last 2 blocks have different color
        //same(n, k) = f(n-2, k)*(k-1)
        //diff(n, k) = f(n-1, k)*(k-1)
        //f(n, k) = f(n-2, k)*(k-1) + f(n-1, k)*(k-1)
        
        long[] dp = new long[n];
        Arrays.fill(dp, -1L);
        dp[0] = k;
        if(n==1) return dp[0];
        dp[1] = k + (k*(k-1));
        return countWaysWithDp(n, k, dp);
    }
    
    private long countWaysWithDp(int n, int k, long[] dp){
        if(dp[n-1]!=-1) return dp[n-1]; //using index 'n-1' for input n as 0 based index
        int mod = 1000000007;
        dp[n-1] = ((countWaysWithDp(n-2, k, dp)*(k-1)) + (countWaysWithDp(n-1, k, dp)*(k-1)))%mod;
        return dp[n-1];
    }
    
}

