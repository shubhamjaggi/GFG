class Solution {

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // create a list of edges to make things easy to for further operations
        List<Edge> edges = new ArrayList<>();
        for(int u=0; u<V; u++) {
            for(int[] neighbour : adj.get(u)) {
                edges.add(new Edge(u, neighbour[0], neighbour[1]));
            }
        }
        
        Collections.sort(edges, Comparator.comparing(Edge::wt));
        
        // create and initialise a parent array
        int[] par = new int[V];
        for(int i=0; i<V; i++) par[i] = i;
        
        int wtSum = 0;
        int edgeCount = 1;
        for(Edge edge : edges) {
            int repU = rep(edge.u, par); // find representative for u's set
            int repV = rep(edge.v, par); // find representative for v's set
            
            if(repU != repV) { // if u and v are not in the same set
                par[repU] = repV; // perform union
                wtSum+=edge.wt; // update wt sum for our MST
                if(++edgeCount == V) break; // as we only want to add V-1 edges
            }
        }
        
        return wtSum;
    }
    
    private static int rep(int x, int[] par) { // method to find set representative
        while(par[x] != x) x = par[x];
        return x;
    }
}

class Edge {
    int u;
    int v;
    int wt;
    
    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
    
    int wt() { return this.wt; } // for creating a Comparator using method reference
}