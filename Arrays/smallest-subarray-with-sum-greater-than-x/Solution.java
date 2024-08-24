class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        int l = 0, r = 0, sum = 0;
        int minLength = arr.length;
        boolean isGreaterSumFound = false;
        
        while(r < arr.length) {
            while(sum <= x && r < arr.length) sum += arr[r++];
            
            while (sum > x) {
                isGreaterSumFound = true;
                minLength = Math.min(minLength, r-l);
                sum -= arr[l++];
            }
        }
        
        return isGreaterSumFound ? minLength : 0;
    }
}