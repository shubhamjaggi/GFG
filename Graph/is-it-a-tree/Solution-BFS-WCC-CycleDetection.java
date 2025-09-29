// User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // create adjacency list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge:edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        
        if(m!=n-1) return false; // exactly n-1 edges should be there in a tree
        
        int[] par=new int[n];
        Arrays.fill(par,-1);
        
        boolean[] vis=new boolean[n];
        int wccCount=0;
        
        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                if(++wccCount==2) return false; // wcc count should be exactly 1 in a tree
                
                Queue<Integer> bfsQueue=new ArrayDeque<>();
                bfsQueue.add(i);
                vis[i]=true;
                while(!bfsQueue.isEmpty()) {
                    int curr=bfsQueue.poll();
                    
                    for(int nei:adj.get(curr)) {
                        if(!vis[nei]) {
                            bfsQueue.add(nei);
                            vis[nei]=true;
                            par[nei]=curr;
                        } else {
                            if(par[curr]!=nei) return false; // cycle detected
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
