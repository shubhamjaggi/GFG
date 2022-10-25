
//User function Template for Java


class Solution {

    public static long maximizeSum(long a[], int n, int k)
    {
        Arrays.sort(a);
        
        long maxNeg = 0L;
        long minPos = 0L;
        
        for(int i=0; i<n && k>=1; i++){
            if(a[i]<0L){
                maxNeg = a[i];
                a[i]=-a[i];
                k--;
            }else if(a[i]==0L){
                k=0;
            }else{
                minPos = a[i];
                break;
            }
        }
        
        long ans=Arrays.stream(a).sum();
        
        if(k%2==1){
            if(minPos!=0L && maxNeg!=0L){
                if(-maxNeg>minPos){
                    ans-=2L*minPos;
                }else{
                    ans-=2L*-maxNeg;
                }
            }
            else if(maxNeg==0L){
                ans-=2L*minPos;
            }
            else{
                ans-=2L*-maxNeg;
            }
        }
        
        return ans;
    }
}