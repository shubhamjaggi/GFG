class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // Kahn's algorithm (Topological sort using BFS traversal)
        int[] res = new int[V];
        int ind = 0;
        
        int[] inDegree = new int[V];
        for(ArrayList<Integer> neighbours : adj) {
            for(int neighbour : neighbours) inDegree[neighbour]++;
        }
        
        boolean[] vis = new boolean[V];
        
        /* calculate the in-degree of all the vertices and then
        add the elements with zero in-degree in the BFS queue */
        Queue<Integer> bfsq = new ArrayDeque<>();
        for(int i=0; i<inDegree.length; i++) {
            if(inDegree[i]==0) bfsq.add(i);
        }
        
        while(!bfsq.isEmpty()) {
            int curr = bfsq.poll();
            vis[curr] = true;
            for(int neighbour : adj.get(curr)) {
                /* we are also updating the in-degree of neighbours
                and adding them to the BFS queue only if their in-degree has become 0 */
                if(!vis[neighbour] && (--inDegree[neighbour]==0)) {
                    bfsq.add(neighbour);
                }
            }
            res[ind++] = curr;
        }
        
        return res;
    }
}