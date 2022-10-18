
/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root){
        if(root==null) return root;
        Node hori = root;
    	while(hori.next!=null){
    	    Node verti = hori;
            verti.bottom = merge(verti.bottom, hori.next);
            hori.next = hori.next.next;
    	}
    	return root;
    }
    
    private Node merge(Node node1, Node node2){
        if(node1==null){
            return node2;
        }
        
        if(node2==null){
            return node1;
        }
        
        Node head = new Node(-1);
        
        Node curr = head;
        while(node1!=null && node2!=null){
            if(node1.data<=node2.data){
                curr.bottom = node1;
                node1 = node1.bottom;
            }else{
                curr.bottom = node2;
                node2 = node2.bottom;
            }
            curr = curr.bottom;
        }
        
        curr.bottom = node1!=null?node1:node2;
        return head.bottom;
    }
}