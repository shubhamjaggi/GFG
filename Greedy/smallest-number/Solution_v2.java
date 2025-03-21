class Solution {
    public String smallestNumber(int s, int d) {
        char[] ans = new char[d];
        for(int i=d; i>=1; i--) {
            if(s>9) {
                ans[i-1]='9';
                s-=9;
            }
            else if(s>1) {
                if(i!=1) {
                    ans[i-1]=Character.forDigit(s-1, 10);
                    s=1;
                }
                else {
                    ans[0]=Character.forDigit(s, 10);
                    s=0;
                }
            }
            else if(s==0) return "-1";
            else {
                if(i>1) ans[i-1]='0';
                else {
                    ans[0]='1';
                    s=0;
                }
            }
        }
        
        return s==0?String.valueOf(ans):"-1"; 
    }
}