class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        
        long[] ng = new long[n];
        long g = Long.MIN_VALUE;
        
        for (int i = n-1; i >= 0; i--) {
            g = Math.max(g, arr[i]);
            ng[i] = g;
        }
        
        long[] pg = new long[n];
        g = Long.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            g = Math.max(g, arr[i]);
            pg[i] = g;
        }
        
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            ans += (Math.min(ng[i], pg[i]) - arr[i]);
        }
        
        return ans;
    } 
}