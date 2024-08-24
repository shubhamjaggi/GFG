class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int array[], int a, int b)
    {
        int l = 0;
        int r = array.length-1;
        
        int i = 0;
        
        while(r >= i) {
            if(array[i] < a) {
                swap(array, i++, l++);
            }
            else if(array[i] > b) {
                swap(array, i, r--);
            }
            else {
                i++;
            }
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}