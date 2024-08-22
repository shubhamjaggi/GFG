class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int diff = arr[n-1] - arr[0];
        
        for(int i=0; i<n-1; i++) {
            int min = Math.min(arr[0] + k, arr[i+1] - k);
            int max = Math.max(arr[n-1] - k, arr[i] + k);
            
            diff = Math.min(diff, max-min);
        }
        
        return diff;
        // code here
    }
}