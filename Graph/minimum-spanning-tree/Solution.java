class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int ans = 0;
        
        boolean[] vis = new boolean[V];
        
        Queue<NodeWrapper> pq = new PriorityQueue<>(Comparator.comparing(NodeWrapper::getWeight));
        pq.add(new NodeWrapper(0, 0));
        
        while(!pq.isEmpty()) {
            NodeWrapper curr = pq.poll();
            if(vis[curr.val]) continue;
            
            vis[curr.val] = true;
            ans+=curr.wt;
            
            for (int[] neighbour : adj.get(curr.val)) {
                if(!vis[neighbour[0]]) {
                    pq.add(new NodeWrapper(neighbour[0], neighbour[1]));
                }
            }
        }
        
        return ans;
    }
}

class NodeWrapper {
    int val;
    int wt;
    
    NodeWrapper(int val, int wt) {
        this.val = val;
        this.wt = wt;
    }
    
    int getWeight() {
        return this.wt;
    }
}