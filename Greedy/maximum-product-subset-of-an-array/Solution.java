
class Solution {
    private static final long MOD = 1000000007L;
    
    private static long mul(long x, long y){
        return ((x%MOD)*(y%MOD))%MOD;
    }
    
    public static int findMaxProduct(int n, int[] arr) {
        int negCount = 0;
        int zeroCount = 0;
        int maxNeg = Integer.MIN_VALUE;
        long ans = 1L;
        
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                zeroCount++;
            }
            else{
                if(arr[i]<0){
                    negCount++;
                    maxNeg = Math.max(maxNeg, arr[i]);
                }
                ans = mul(ans, arr[i]);
            }
        }
        
        if(zeroCount==n || (negCount==1 && zeroCount!=0 && zeroCount==n-1)){
            return 0;
        }else if(negCount==n && n==1){
            return (int)ans;
        }else if(negCount%2!=0){
            return (int)(ans/=maxNeg);
        }else{
            return (int)ans;
        }
    }
}
        