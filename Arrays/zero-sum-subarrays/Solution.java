class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        Map<Long, Integer> prefixMap = new HashMap<>();
        
        int ans = 0;
        
        long prefixSum = 0L;
        prefixMap.put(prefixSum, 1);
        
        for(int i=0; i<n; i++) {
            prefixSum+=arr[i];
            if (prefixMap.containsKey(prefixSum)) {
                int count = prefixMap.get(prefixSum);
                ans+=count;
                prefixMap.put(prefixSum, count + 1);
            }
            else {
                prefixMap.put(prefixSum, 1);
            }
        }
        
        return ans;
        //Your code here
    }
}