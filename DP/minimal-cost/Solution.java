class Solution {
    public int minimizeCost(int arr[], int k) {
        // code here
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return min(arr, 0, k, dp);
    }
    
    private int min(int[] arr, int beg, int k, int[] dp) {
        if(dp[beg]!=Integer.MAX_VALUE) return dp[beg];
        if(beg==arr.length-1) return 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=k && (beg+i)<arr.length; i++) {
            min=Math.min(Math.abs(arr[beg+i] - arr[beg])+min(arr, beg+i, k, dp), min);
        }
        return dp[beg] = min;
    }
}