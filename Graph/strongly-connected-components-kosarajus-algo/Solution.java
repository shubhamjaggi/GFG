class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n=adj.size();
        
        // get topological stack
        Stack<Integer> topoStack = new Stack<>();
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!vis[i]) dfsTopo(adj,i,vis,topoStack);
        }
        
        // reverse the graph
        ArrayList<ArrayList<Integer>> revAdj=new ArrayList<>();
        for(int i=0; i<n; i++) revAdj.add(new ArrayList<>());
        for(int u=0; u<n; u++) {
            for(int v:adj.get(u)) revAdj.get(v).add(u);
        }
        
        int ans=0;
        
        // dfs based on popped nodes from topo stack (on the reversed graph)
        Arrays.fill(vis,false);
        while(!topoStack.isEmpty()) {
            int u=topoStack.pop();
            if(!vis[u]) {
                ans++;
                dfs(revAdj,u,vis);
            }
        }
        
        return ans;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis) {
        vis[i]=true;
        for(int nei:adj.get(i)) {
            if(!vis[nei]) dfs(adj,nei,vis);
        }
    }
    
    private void dfsTopo(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, Stack<Integer> topoStack) {
        vis[i]=true;
        for(int nei:adj.get(i)) {
            if(!vis[nei]) dfsTopo(adj,nei,vis,topoStack);
        }
        topoStack.push(i);
    }
}