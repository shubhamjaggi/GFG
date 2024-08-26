class Solution {
    public void segregateElements(int[] arr) {
        // Your code goes here
        int n = arr.length;
        int negCount = 0;
        for(int i = 0; i < n; i++) if(arr[i] < 0) negCount++;
        int posCount = n - negCount;
        int[] aux = new int[arr.length];
        for(int i = 0, j = posCount, k = 0; i < n; i++) {
            if(arr[i] < 0) aux[j++] = arr[i];
            else aux[k++] = arr[i];
        }
        for(int i = 0; i < n; i++) arr[i] = aux[i];
    }
}