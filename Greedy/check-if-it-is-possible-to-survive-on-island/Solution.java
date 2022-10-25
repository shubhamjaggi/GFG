
//User function Template for Java

class Solution{
    static int minimumDays(int S, int N, int M){
        int total = S*M;
        int numSundays = S/7;
        int res = (int)Math.ceil(((double)total)/((double)N));
        return res<=(S-numSundays)?res:-1;
    }
}