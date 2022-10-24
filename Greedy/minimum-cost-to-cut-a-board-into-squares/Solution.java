
class Solution {
    public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
        X = Arrays.stream(X).boxed().sorted(Comparator.reverseOrder()).mapToInt(a->a).toArray();
        Y = Arrays.stream(Y).boxed().sorted(Comparator.reverseOrder()).mapToInt(a->a).toArray();

        int i=0, j=0;
        int hor=1, ver=1;
        int res=0;
        
        while(i<M || j<N){
            if(j>=N || (i<M && X[i]>=Y[j])){
                res+=X[i]*ver;
                hor++;
                i++;
                continue;
            }
            if(i>=M || (j<N && Y[j]>X[i])){
                res+=Y[j]*hor;
                ver++;
                j++;
                continue;
            }
        }
        
        return res;
    }
}
        