class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        
        int minDiff = arr[n-1]-arr[0]; // default value (if all the elements are incremented or decremented collectively)
        
        
        /*
          -> all the elements to the left of pivot will be incremented
          -> all the elements to the right of pivot (and the element at the pivot itself) will be decremented
        */
        for (int pivot = 1; pivot < n; pivot++) {
            int min = Math.min(arr[0]+k, arr[pivot]-k);
            if (min<0) continue; // not consider such pivot as per question
            int max = Math.max(arr[n-1]-k, arr[pivot-1]+k);
            minDiff = Math.min(minDiff, max-min);
        }
        
        return minDiff;
    }
}