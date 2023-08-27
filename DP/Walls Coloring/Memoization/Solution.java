class Solution{
	int minCost(int [][] colors, int N){
        //Write your code here
        int[][] dp = new int[N + 1][3];
        java.util.stream.IntStream.rangeClosed(0, N - 1).forEach(i -> Arrays.fill(dp[i], -1));
        return getMinCost(colors, N, 0, -1, dp);
    }
    
    private int getMinCost(int[][] colors, int N, int i, int prev, int[][] dp) {
        if(i >= N) return 0;
        
        if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];
        
        int[] costs = {-1, -1, -1};
        
        if(prev != 0) {
            costs[0] = colors[i][0] + getMinCost(colors, N, i + 1, 0, dp);//pink cost
        }
        
        if(prev != 1) {
            costs[1] = colors[i][1] + getMinCost(colors, N, i + 1, 1, dp);//black cost
        }
        
        if(prev != 2) {
            costs[2] = colors[i][2] + getMinCost(colors, N, i + 1, 2, dp);//yellow cost
        }
        
        int minCost = Arrays.stream(costs).filter(a -> a != -1).min().getAsInt();
        
        return prev == -1 ? minCost : (dp[i][prev] = minCost);
    }
}