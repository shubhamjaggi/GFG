class Solution {
    // Should return true if there is a triplet with sum equal
    // to x in arr[], otherwise false
    public static boolean find3Numbers(int arr[], int n, int x) {

        // Your code Here
        Arrays.sort(arr);
        
        for (int i=0; i < n - 2; i++) {
            int first = arr[i];
            int p = i + 1;
            int q = n - 1;
            
            int target = x - arr[i];
            
            while(q > p) {
                int currTwoSum = arr[p] + arr[q];
                if(currTwoSum > target) {
                    q--;
                }
                else if (currTwoSum < target) {
                    p++;
                }
                else {
                    return true;
                }
            }
        }
        
        return false;
    }
}