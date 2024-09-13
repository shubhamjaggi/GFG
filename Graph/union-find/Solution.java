class Solution
{
    //Function to merge two nodes a and b.
    public void union_(int a, int b, int par[], int rank[])
    {
        /*
            if a and b are already part of the same
            set, then nothing needs to be done for
            the union operation
        */
        if (isConnected(a, b, par, rank)) return;
        
        int repA = rep(a, par); // find representative of set in which a is present
        int repB = rep(b, par); // find representative of set in which b is present
        
        if(rank[a] < rank[b]) par[repA] = repB; // b's tree is higher (move a's tree inside b's tree)
        else if(rank[b] < rank[a]) par[repB] = repA; // a's tree is higher (move b's tree inside a's tree)
        else {
            par[repA] = repB; // move any tree inside the other tree
            rank[repB]++; // containing tree is now higher
        }
    }

    //Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        /*
            if representatives of the a's set is same as
            the representative of b's set, then a and b
            are connected
        */
        return rep(a, par) == rep(b, par);
    }
    
    /*
        find representative (root of the imaginary tree) of the set
        in which x is present
    */
    private int rep(int x, int[] par) {
        while(par[x] != x) x = par[x];
        return x;
    }

}