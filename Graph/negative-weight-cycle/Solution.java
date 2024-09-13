class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        if (edges.length == 0) return 0;
        
        // take source as u of first edge
        dist[edges[0][0]] = 0;
        
        
        // iterate n-1 times
        for(int i=1; i<=n-1; i++) {
            for(int j=0; j<edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                dist[v] = dist[u] != Integer.MAX_VALUE ? Math.min(dist[u]+wt, dist[v]) : dist[v];
            }
        }
    
        // iterate 1 more time to see if lesser value still appears
        for(int j=0; j<edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u]+wt) return 1; //negative weight cycle present
        }
        
        return 0; //negative weight cycle not present
    }
}