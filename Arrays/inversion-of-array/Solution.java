class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    
    static long inversionCount(long arr[], int n) {
        long[] count = new long[1];
        sort(arr, 0, n-1, count);
        return count[0];
    }
    
    private static long[] sort(long[] arr, int start, int end, long[] count) {
        if(start == end) {
            long[] sorted = {arr[start]};
            return sorted;
        }
        int mid = (end+start)/2;
        long[] arr1 = sort(arr, start, mid, count);
        long[] arr2 = sort(arr, mid+1, end, count);
        return merge(arr1, arr2, count);
    }
    
    private static long[] merge(long[] arr1, long[] arr2, long[] count) {
        int i=0, j=0, z=0;
        long[] merged = new long[arr1.length + arr2.length];
        while (i<arr1.length && j<arr2.length) {
            if(arr1[i] < arr2[j]) {
                merged[z++] = arr1[i++];
            }
            else if (arr1[i] > arr2[j]) {
                count[0] += (arr1.length-i);
                merged[z++] = arr2[j++];
            }
            else {
                merged[z++] = arr1[i++];
            }
        }
        
        while (i < arr1.length) {
            merged[z++] = arr1[i++];
        }
        
        while (j < arr2.length) {
            merged[z++] = arr2[j++];
        }
        
        return merged;
    }
}