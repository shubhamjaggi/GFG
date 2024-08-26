class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long ans = Long.MIN_VALUE;
        long prefix = 1;
        long suffix = 1;
        for (int i = 0; i < n; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            
            prefix = prefix * arr[i];
            suffix = suffix * arr[n-i-1];
            
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        
        return ans;
    }
}