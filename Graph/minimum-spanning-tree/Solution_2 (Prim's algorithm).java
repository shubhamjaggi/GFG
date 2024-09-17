class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean[] isAdded = new boolean[V];
        boolean[] isRead = new boolean[V];
        
        Queue<To> pq = new PriorityQueue<>(Comparator.comparing(To::wt));
        pq.add(new To(0, 0));
        isAdded[0] = true;
        
        int res = 0;
        
        while(!pq.isEmpty()) {
            To to = pq.poll();
            
            if (isRead[to.v]) continue;
            isRead[to.v] = true;
            
            res += to.wt;
            
            for(int[] neighbourTo : adj.get(to.v)) {
                int v = neighbourTo[0];
                int wt = neighbourTo[1];
                pq.add(new To(v, wt));
                isAdded[v] = true;
            }
        }
        
        return res;
    }
}

class To {
    int v;
    int wt;
    
    To(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
    
    int wt() {
        return this.wt;
    }
}