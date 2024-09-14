class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        /* create a result variable that will eventually
            store the sum of the lengths of the edges in the MST */
        int res = 0;
        
        /* create a priority queue that implements
            a NodeWrapper min heap based on weight (length) */
        Queue<NodeWrapper> pq = new PriorityQueue<>(Comparator.comparing(NodeWrapper::getWeight));
        
        // add the 0th vertex to the priority queue
        pq.add(new NodeWrapper(0, 0));
        
        // create a visited array to keep track of visited nodes
        boolean[] vis = new boolean[V];
        
        while(!pq.isEmpty()) {
            // extract edge corresponding to the min length
            NodeWrapper curr = pq.poll();
            
            int u = curr.val;
            
            /* if current vertex has already been visited
                then move to the next iteration */
            if(vis[u]) continue;
            
            /* if the current vertex has not been
                visited then mark it as visited */
            vis[u] = true;
            
            // add the length of the current edge to the result
            res+=curr.wt;
            
            /* check all the neighbours of the current vertex */
            for (int[] neighbour : adj.get(u)) {
                
                int nVertex = neighbour[0]; // neighbour vertex
                int nWeight = neighbour[1]; // length of edge connecting u to neighbour vertex
                
                /* if neighbour vertex has not been visited then
                    add the 'edge with the neighbour' to the priority queue */
                if(!vis[nVertex]) {
                    pq.add(new NodeWrapper(nVertex, nWeight));
                }
            }
        }
        
        // return the result array    
        return res;
    }
}

class NodeWrapper {
    int val;
    int wt;
    
    NodeWrapper(int val, int wt) {
        this.val = val;
        this.wt = wt;
    }
    
    // for using method reference while creating the comparator
    int getWeight() {
        return this.wt;
    }
}