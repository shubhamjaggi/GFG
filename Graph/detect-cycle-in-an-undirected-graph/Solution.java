class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                if(dfs(i, -1, adj, vis)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(int val, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[val] = true;
        for(int neighbour : adj.get(val)) {
            if(!vis[neighbour]) {
                if (dfs(neighbour, val, adj, vis)) return true;
            }
            else if(neighbour!=parent) {
                return true;
            }
        }
        return false;
    }
}