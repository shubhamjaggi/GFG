class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] vis = new boolean[V];
        Stack<Integer> tmp = new Stack<>();
        
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(i, adj, vis, tmp);
            }
        }
        
        int[] res = new int[tmp.size()];
        int ind=0;
        while(!tmp.isEmpty()) res[ind++] = tmp.pop();
        return res;
    }
    
    private static void dfs(int val, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> tmp) {
        vis[val] = true;
        for(int neighbour : adj.get(val)) {
            if(!vis[neighbour]) {
                dfs(neighbour, adj, vis, tmp);
            }
        }
        
        tmp.push(val);
    }
}