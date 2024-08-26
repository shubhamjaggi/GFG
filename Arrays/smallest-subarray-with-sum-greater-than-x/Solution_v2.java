class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > x) {
                ans = Math.min(right - left + 1, ans);
                sum-=arr[left++];
            }
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}