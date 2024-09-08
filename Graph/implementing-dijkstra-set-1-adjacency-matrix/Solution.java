class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        /* create a result array that will eventually
            store the min distance from S */
        int[] res = new int[adj.size()];
        
        // initialise all distances with positive infinity
        Arrays.fill(res, Integer.MAX_VALUE);
        
        // distance of S from S is zero
        res[S] = 0;
        
        /* create a priority queue that implements
            a NodeWrapper min heap based on weight */
        Queue<NodeWrapper> pq = new PriorityQueue<>(Comparator.comparing(NodeWrapper::getWeight));
        
        // add the source vertex to the priority queue
        pq.add(new NodeWrapper(S, 0));
        
        // create a visited array to keep track of visited nodes
        boolean[] vis = new boolean[adj.size()];
        
        while(!pq.isEmpty()) {
            // extract min based on weight
            NodeWrapper curr = pq.poll();
            
            int u = curr.val;
            
            /* if current vertex has already been visited
                then move to the next iteration */
            if(vis[u]) continue;
            
            /* if the current vertex has not been
                visited then mark it as visited */
            vis[u] = true;
            
            /* check all the neighbours of the current vertex */
            for(ArrayList<Integer> neighbour : adj.get(u)) {
                
                int nVertex = neighbour.get(0); // neighbour vertex
                int nWeight = neighbour.get(1); // length of edge connecting u to neighbour vertex
                
                /* check if the sum of the shortest path till
                    the current vertex u and the length of the edge
                    connecting u to the neighbour is less than the
                    stored min distance till the neighbour vertex */
                if(res[u] + nWeight < res[nVertex]) {
                    // update min distance (in result array) for the neighbour vertex
                    res[nVertex] = res[u] + nWeight;
                    
                    /* add the neighbour vertex and its computed
                        min distance to the priority queue */
                    pq.add(new NodeWrapper(nVertex, res[nVertex]));
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