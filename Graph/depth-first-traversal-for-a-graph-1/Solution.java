class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        res.add(0);
        vis[0] = true;
        dfs(0, vis, adj, V, res);
        return res;
    }
    
    private void dfs(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int V, ArrayList<Integer> res) {
        for(int neighbour : adj.get(v)) {
            if(!vis[neighbour]) {
                res.add(neighbour);
                vis[neighbour] = true;
                dfs(neighbour, vis, adj, V, res);
            }
        }
    }
}