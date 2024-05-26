class Solution
{
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        
        Map<Integer, Node> parentMap = new HashMap<>();
        parentMap.put(root.data, null);
        Node targetNode = populateParentMapAndGetTargetNode(root, parentMap, target);
        
        List<Integer> visited = new ArrayList<>();
        Queue<Node> lotq = new ArrayDeque<>();
        
        lotq.add(targetNode);
        visited.add(target);
        
        int res = 0;
        while(!lotq.isEmpty()) {
            boolean isMoreToBeBurnt = false;
            int size = lotq.size();
            
            for(int i = 0; i < size; i++) {
                Node burnt = lotq.poll();
            
                if(burnt.left != null && !visited.contains(burnt.left.data)) {
                    lotq.add(burnt.left);
                    visited.add(burnt.left.data);
                    isMoreToBeBurnt = true;
                }
                
                if(burnt.right != null && !visited.contains(burnt.right.data)) {
                    lotq.add(burnt.right);
                    visited.add(burnt.right.data);
                    isMoreToBeBurnt = true;
                }
                
                Node parent = parentMap.get(burnt.data);
                if(parent != null && !visited.contains(parent.data)) {
                    lotq.add(parent);
                    visited.add(parent.data);
                    isMoreToBeBurnt = true;
                }
            }
            
            if (isMoreToBeBurnt) res++;
        }
        
        return res;
    }
    
    private static Node populateParentMapAndGetTargetNode(
        Node root,
        Map<Integer, Node> parentMap,
        int target
    ) {
        Queue<Node> lotq = new ArrayDeque<>();
        lotq.add(root);
        
        Node targetNode = null;
        
        while(!lotq.isEmpty()) {
            Node curr = lotq.poll();
            
            if(curr.data == target) targetNode = curr;
            
            if(curr.left != null) {
                lotq.add(curr.left);
                parentMap.put(curr.left.data, curr);
            }
            
            if(curr.right != null) {
                lotq.add(curr.right);
                parentMap.put(curr.right.data, curr);
            }
        }
        
        return targetNode;
    }
}