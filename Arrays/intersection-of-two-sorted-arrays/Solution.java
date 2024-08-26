class Solution {
    // Function to return a list containing the intersection of two arrays.
    static ArrayList<Integer> printIntersection(int arr1[], int arr2[]) {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) i = next(arr1, i);
            else if(arr1[i] > arr2[j]) j = next(arr2, j);
            else {
                ans.add(arr1[i]);
                i = next(arr1, i);
                j = next(arr2, j);
            }
        }
        if(ans.isEmpty()) ans.add(-1);
        return ans;
    }
    
    private static int next(int[] arr, int ind) {
        ind++;
        while(ind < arr.length && arr[ind] == arr[ind-1]) ind++;
        return ind;
    }
}