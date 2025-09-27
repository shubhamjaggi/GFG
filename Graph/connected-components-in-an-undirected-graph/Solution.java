class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        
        // make adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge:edges) {
            int u=edge[0]; int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] vis=new boolean[V];
        
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(adj,i,vis,comp);
                comps.add(comp);
            }
        }
        
        return comps;
    }
    
    private void dfs(List<List<Integer>> adj, int i, boolean[] vis, ArrayList<Integer> comp) {
        vis[i]=true;
        for(int nei:adj.get(i)) {
            if(!vis[nei]) {
                dfs(adj,nei,vis,comp);
            }
        }
        comp.add(i);
    }
}