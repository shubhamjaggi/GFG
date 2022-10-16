

class Solution
{
    long countWays(int n,int k){
        //f(n, k) = same(n, k) + diff(n, k)
        //same(n, k) : number of ways in which last 2 blocks have same color
        //diff(n, k) : number of ways in which last 2 blocks have different color
        //same(n, k) = f(n-2, k)*(k-1)
        //diff(n, k) = f(n-1, k)*(k-1)
        //f(n, k) = f(n-2, k)*(k-1) + f(n-1, k)*(k-1)
        
        int mod = 1000000007;
        
        if(n==1) return k;
        if(n==2) return k + (k*(k-1));
        
        return ((countWays(n-2, k)*(k-1)) + (countWays(n-1, k)*(k-1)))%mod;
    }
}