class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            if(A[i] < A[i+1]) {
                ArrayList<Integer> txPair = new ArrayList<>();
                txPair.add(i); txPair.add(i+1);
                ans.add(txPair);
            }
        }
        return ans;
    }
}