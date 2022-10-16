
//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    {
       //f(n) = f(n-1) + (n-1)*f(n-2)
       //nth person can be single in f(n-1) ways
       //nth person can be paired with n-1 persons.. n-2 persons will remain after that pair
       long[] dp = new long[n];
       
       dp[0] = 1L; //dp[0] means f(1) as zero based index in array
       if(n==1) return dp[0];
       dp[1] = 2L;
       
       for(int i=2; i<n; i++){
           dp[i] = (dp[i-1] + i*dp[i-2])%1000000007;
       }
       
       return dp[n-1];
    }
}    
 