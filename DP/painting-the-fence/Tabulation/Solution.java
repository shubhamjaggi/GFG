

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
        dp[0] = k;
        if(n==1) return dp[0];
        dp[1] = k + (k*(k-1));
        int mod = 1000000007;
        for(int i=2; i<n; i++) dp[i] = ((dp[i-2]*(k-1)) + (dp[i-1]*(k-1)))%mod;
        return dp[n-1];
    }
    
}

