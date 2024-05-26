class NodeWrapper {
    Node left;
    Node right;
    int data;
    int hd;
    
    NodeWrapper(Node node, int hd) {
        this.left = node.left;
        this.right = node.right;
        this.data = node.data;
        this.hd = hd;
    }
}

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        
        // add your code
        Queue<NodeWrapper> lotq = new ArrayDeque<>();
        lotq.add(new NodeWrapper(root, 0));
        
        Map<Integer, Integer> hdMap = new TreeMap<>();
        
        while(!lotq.isEmpty()) {
            NodeWrapper curr = lotq.poll();
            
            if(!hdMap.containsKey(curr.hd)) {
                hdMap.put(curr.hd, curr.data);
            }
            
            if(curr.left != null) {
                lotq.add(new NodeWrapper(curr.left, curr.hd - 1));
            }
            
            if(curr.right != null) {
                lotq.add(new NodeWrapper(curr.right, curr.hd + 1));
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        hdMap.keySet().stream().forEach(a -> res.add(hdMap.get(a)));
        return res;
    }
}