class Solution{
    static List<Integer> nextPermutation(int N, int arr[]) {
        int i;
        for (i = N-1; i > 0 && arr[i] <= arr[i-1]; i--); i--;
        if(i == -1) return reverse(arr, 0, N-1);
        int j;
        for (j = N-1; j > 0 && arr[j] <= arr[i]; j--);
        swap(arr, i, j);
        return reverse(arr, i+1, N-1);
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static List<Integer> reverse(int[] arr, int i, int j) {
        int mid = (i + j)/2;
        for(int x = i; x <= mid; x++) swap(arr, x, j-(x-i));
        return Arrays.stream(arr).boxed().collect(java.util.stream.Collectors.toList());
    }
}