class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr); Arrays.sort(dep);
        int i=0, j=0, minPlatforms=0;
        while(i<arr.length) {
            if(arr[i++]<=dep[j]) minPlatforms++; else j++;
        }
        return minPlatforms;
    }
}