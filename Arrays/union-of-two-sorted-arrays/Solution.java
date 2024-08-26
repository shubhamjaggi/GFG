class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        int i = 0, j = 0;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(i < n && j < m) {
            if(arr1[i] < arr2[j]) {
                ans.add(arr1[i]);
                i = next(arr1, i);
            }
            else if(arr1[i] > arr2[j]) {
                ans.add(arr2[j]);
                j = next(arr2, j);
            }
            else {
                ans.add(arr1[i]);
                i = next(arr1, i);
                j = next(arr2, j);
            }
        }
        
        while(i < n) {
            ans.add(arr1[i]);
            i = next(arr1, i);
        }
        
        while(j < m) {
            ans.add(arr2[j]);
            j = next(arr2, j);
        }
        
        return ans;
    }
    
    private static int next(int[] arr, int ind) {
        ind++;
        while(ind < arr.length && arr[ind] == arr[ind-1]) ind++;
        return ind;
    }
}