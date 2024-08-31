class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        
        long[] res = new long[n];
        
        Stack<Long> temp = new Stack<>();
        for(int i = n-1; i >=0 ; i--) {
            while (!temp.isEmpty() && arr[i] >= temp.peek()) temp.pop();
            if (temp.isEmpty()) res[i] = -1;
            else res[i] = temp.peek();
            temp.push(arr[i]);
        }
        
        return res;
    } 
}