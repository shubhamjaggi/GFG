class Solution {
    long maxSubarraySum(int[] arr) {
        
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) sum = 0;
        }
        
        return maxSum;
    }
}