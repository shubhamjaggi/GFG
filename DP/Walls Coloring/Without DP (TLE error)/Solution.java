class Solution{
	int minCost(int [][] colors, int N){
        //Write your code here
        return getMinCost(colors, N, 0, -1);
    }
    
    private int getMinCost(int[][] colors, int N, int i, int prev) {
        if(i >= N) return 0;
        
        int[] costs = {-1, -1, -1};
        
        if(prev != 0) {
            costs[0] = colors[i][0] + getMinCost(colors, N, i + 1, 0);//pink cost
        }
        
        if(prev != 1) {
            costs[1] = colors[i][1] + getMinCost(colors, N, i + 1, 1);//black cost
        }
        
        if(prev != 2) {
            costs[2] = colors[i][2] + getMinCost(colors, N, i + 1, 2);//yellow cost
        }
        
        return Arrays.stream(costs).filter(a -> a != -1).min().getAsInt();
    }
}