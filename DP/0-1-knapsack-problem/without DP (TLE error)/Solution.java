
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n){
        return ans(W, wt, val, n-1);
    }
    
    static int ans(int capacity, int wt[], int val[], int i){
        if(i==0){
            return wt[0]<=capacity?val[0]:0;
        }
        int ans1=0;
        if (wt[i]<=capacity) ans1 = val[i] + ans(capacity-wt[i], wt, val, i-1);
        int ans2 = 0 + ans(capacity, wt, val, i-1);
        return Math.max(ans1, ans2);
    }
}
