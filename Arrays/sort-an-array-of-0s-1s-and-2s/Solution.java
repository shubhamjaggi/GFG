class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here 
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        
        for(int i = 0; i < n; i++) {
            if(a[i] == 0) zeroCount++;
            if(a[i] == 1) oneCount++;
            if(a[i] == 2) twoCount++;
        }
        
        for(int i = 0; i < zeroCount; i++) a[i] = 0;
        for(int i = zeroCount; i < n - twoCount; i++) a[i] = 1;
        for(int i = n - twoCount; i < n; i++) a[i] = 2;
    }
}