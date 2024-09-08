class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                if (dfs(i, adj, vis, rec)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int val, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] rec) {
        vis[val] = true;
        rec[val] = true;
        
        for(int neighbour : adj.get(val)) {
            if(!vis[neighbour]) {
                if(dfs(neighbour, adj, vis, rec)) return true;
            }
            else if(rec[neighbour]) return true;
        }
        
        rec[val] = false;
        return false;
    }
}