

class Solution
{
    private final long modConst = 1000000007L;
    
    private long mod(long a){
        return a%modConst;
    }
    
    private long add(long a, long b){
        return mod(mod(a) + mod(b));
    }
    
    private long mul(long a, long b){
       return mod(mod(a) * mod(b));
    }
    
    long countWays(int n,int k){
        //f(n, k) = same(n, k) + diff(n, k)
        //same(n, k) : number of ways in which last 2 blocks have same color
        //diff(n, k) : number of ways in which last 2 blocks have different color
        //same(n, k) = f(n-2, k)*(k-1)
        //diff(n, k) = f(n-1, k)*(k-1)
        //f(n, k) = f(n-2, k)*(k-1) + f(n-1, k)*(k-1)
        
        return ans(n, k);
    }
    
    private long ans(int n, int k){
        long[] dp = new long[n+1];
        dp[1] = k;
        if(n==1) return dp[1];
        dp[2] = add(k, mul(k, k-1));
        for(int i=3; i<=n; i++){
            dp[i] = add(mul(dp[i-2], k-1), mul(dp[i-1], k-1));
        }
        return dp[n];
    }
    
}

