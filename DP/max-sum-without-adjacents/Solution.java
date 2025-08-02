class Solution {
    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        if(n == 1) return dp[0];
        
        dp[1] = Math.max(dp[0], arr[1]);
        
        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], (dp[i-2]+arr[i]));
        }
        
        return dp[n-1];
    }
}