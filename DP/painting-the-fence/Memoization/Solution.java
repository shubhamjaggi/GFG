

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
        
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1L);
        return ans(n, k, dp);
    }
    
    private long ans(int n, int k, long[] dp){
        if(n==1) return k;
        if(n==2) return add(k, mul(k, k-1));
        if(dp[n]!=-1) return dp[n];
        return dp[n] = add(mul(ans(n-2, k, dp), k-1), mul(ans(n-1, k, dp), k-1));
    }
    
}

