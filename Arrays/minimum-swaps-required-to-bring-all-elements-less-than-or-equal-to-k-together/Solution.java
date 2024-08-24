class Complete{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        
        int count = 0;
        for(int i = 0; i < n; i++) if(arr[i] <= k) count++;
        
        int swaps = 0;
        for(int i = 0; i < count; i++) if(arr[i] > k) swaps++;
        
        int minSwaps = swaps;
        
        for(int l = 1; l <= n - count; l++) {
            int r = l + count - 1;
            if(arr[l - 1] > k) swaps--;
            if(arr[r] > k) swaps++;
            minSwaps = Math.min(swaps, minSwaps);
        }
        
        return minSwaps;
    }
    
    
}