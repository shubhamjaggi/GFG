class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        queue.add(0);
        vis[0] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for(int neighbour : adj.get(curr)) {
                if(!vis[neighbour]) {
                    queue.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return res;
    }
}