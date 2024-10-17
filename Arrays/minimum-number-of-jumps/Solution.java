class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        
        int low=0;
        int high=0;
        
        int jumps=0;
        
        while(high < n-1) {
            int nextHigh = high;
            
            for(int i=low; i<=high; i++) {
                nextHigh = Math.max(nextHigh, i+arr[i]);
            }
            
            if (nextHigh == high) return -1;
            
            low = high+1;
            high = Math.min(n-1, nextHigh);
            
            jumps++;
        }
        
        return jumps;
    }
}