class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] res = new int[V];
        int DEFAULT_MAX = 100000000;
        Arrays.fill(res, DEFAULT_MAX);
        int edgeCount = edges.length;
        
        
        res[src]=0;
        
        for(int i=0; i<V; i++) {
            for(int j=0; j<edgeCount; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int d = edges[j][2];
                if(res[u]!=DEFAULT_MAX && res[u]+d < res[v]) {
                    if(i==V-1) { // negative cycle present
                        int[] invalidRes = {-1};
                        return invalidRes;
                    }
                    res[v] = res[u]+d;
                }
                
            }
        }
        
        return res;
    }
}