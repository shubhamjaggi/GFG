class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> levelMap = new TreeMap<>();
        
        Queue<NodeWrapper> lotq = new ArrayDeque<>();
        lotq.add(new NodeWrapper(root, 0));
        
        while(!lotq.isEmpty()) {
            NodeWrapper curr = lotq.poll();
            
            if (!levelMap.containsKey(curr.level)) {
                levelMap.put(curr.level, curr.node.data);
            }
            
            if(curr.node.left!=null) {
                lotq.add(new NodeWrapper(curr.node.left, curr.level+1));
            }
            
            if(curr.node.right!=null) {
                lotq.add(new NodeWrapper(curr.node.right, curr.level+1));
            }
        }
        
        levelMap.keySet().stream().map(levelMap::get).forEach(ans::add);
        return ans;
    }
    
    class NodeWrapper {
        Node node;
        int level;
        NodeWrapper(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}