
//User function Template for Java
class Solution{
    static String smallestNumber(int S, int D){
        if(S>9*D) return "-1";
        StringBuilder sb = new StringBuilder(D);
        ans(S, D, sb, true);
        return sb.toString();
    }
    
    private static void ans(int S, int D, StringBuilder sb, boolean isFirst){
        if(D==1) {
            sb.append(String.valueOf(S));
            return;
        }
        int d = S-9*(D-1);
        if(d<=0){
            if(isFirst){
                sb.append(String.valueOf("1"));
                S--;
            }else{
                sb.append(String.valueOf("0"));
            }
        }
        else{
            sb.append(String.valueOf(d));
            S-=d;
        }
        D--;
        ans(S, D, sb, false);
    }
}