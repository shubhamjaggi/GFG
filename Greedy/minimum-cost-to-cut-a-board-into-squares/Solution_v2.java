class Solution {
    public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
        Integer[] A = Arrays.stream(X).boxed().toArray(Integer[]::new);
        Integer[] B = Arrays.stream(Y).boxed().toArray(Integer[]::new);
        
        Arrays.sort(A, Comparator.reverseOrder());
        Arrays.sort(B, Comparator.reverseOrder());
        
        int i=0, j=0, hr=1, vr=1, ans=0;
        while(i<M && j<N) {
            if (A[i]>B[j]){
                ans+=(A[i++]*hr);
                vr++;
            }
            else {
                ans+=(B[j++]*vr);
                hr++;
            }
        }
        
        while(i!=M) {
            ans+=(A[i++]*hr);
            vr++;
        }
        
        while(j!=N) {
            ans+=(B[j++]*vr);
            hr++;
        }
        
        return ans;
    }
}