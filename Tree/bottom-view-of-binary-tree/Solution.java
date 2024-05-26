class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Node> lotq = new ArrayDeque<>();
        
        root.hd = 0;
        lotq.add(root);
        
        while(!lotq.isEmpty()) {
            Node curr = lotq.poll();
            hdMap.put(curr.hd, curr.data);
            if(curr.left != null) {
                curr.left.hd = curr.hd - 1;
                lotq.add(curr.left);
            }
            
            if(curr.right != null) {
                curr.right.hd = curr.hd + 1;
                lotq.add(curr.right);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int hd : hdMap.keySet()) {
            res.add(hdMap.get(hd));
        }
        
        return res;
    }
}