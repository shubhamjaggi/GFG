

// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int len=arr.length;
        if(len>1){
            int i;
            for(i=len-2;i>=0 && arr[i+1]<=arr[i]; i--);
            if(i!=-1){
                int j;
                for(j=len-1;arr[j]<=arr[i]; j--);
                swap(arr, i, j);
            }
            reverse(arr, i+1);
        }
        return Arrays.stream(arr).boxed().collect(java.util.stream.Collectors.toList());
    }
    
    private static void swap(int arr[], int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i]=temp;
    }
    
    private static void reverse(int[] arr, int startIndex){
        int i=startIndex, j=arr.length-1;
        while(i<j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}