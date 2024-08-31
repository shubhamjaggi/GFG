class Solution {
    public static int findCatalan(int n) {
        // code here
        long[] dp = new long[n+1];
        
        dp[0] = 1; dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            for(int j=0; j < i; j++) {
                dp[i] = mod(dp[i] + dp[j]*dp[i-j-1]);
            }
        }
        
        return (int)dp[n];
    }
    
    private static int mod(long x) {
        return (int)(x % 1000000007L);
    }
}