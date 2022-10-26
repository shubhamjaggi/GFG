
class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        int sum1 = Arrays.stream(S1).sum();
        int sum2 = Arrays.stream(S2).sum();
        int sum3 = Arrays.stream(S3).sum();
        int i=0, j=0, k=0;
        
        while((sum1!=sum2 || sum2!=sum3)){
            if (sum1==0 || sum2==0 || sum3==0) return 0;
            int minSum = Math.min(Math.min(sum1, sum2), sum3);
            while(minSum<sum1) sum1-=S1[i++];
            while(minSum<sum2) sum2-=S2[j++];
            while(minSum<sum3) sum3-=S3[k++];
        }
        
        return sum1;
    }
}
        