class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        Map<Long, Integer> prefixMap = new HashMap<>();
        long prefixSum = 0L;
        int ans = 0;
        for(int i=0; i<n; i++) {
            prefixSum += arr[i];
            if(prefixSum == 0L) ans++;
            if(prefixMap.containsKey(prefixSum)) {
                ans += prefixMap.get(prefixSum);
            }
            if (prefixMap.containsKey(prefixSum)) {
                int count = prefixMap.get(prefixSum);
                prefixMap.put(prefixSum, count + 1);
            }
            else {
                prefixMap.put(prefixSum, 1);
            }
        }
        return ans;
    }
}