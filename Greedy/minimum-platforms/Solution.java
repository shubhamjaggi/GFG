
//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count = 0;
        int res = 0;
        int i=0, j=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                count++;
                res = Math.max(res, count);
                i++;
            }else{
                count--;
                j++;
            }
        }
        return res;
    }
    
}