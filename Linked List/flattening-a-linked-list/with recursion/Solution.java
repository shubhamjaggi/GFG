
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
        Node head1 = root;
        Node head2 = flatten(root.next);
        head1.next = null;
        return merge(head1, head2);
    }
    
    private Node merge(Node node1, Node node2){
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        Node res;
        if(node1.data<=node2.data){
            res = node1;
            res.bottom = merge(node1.bottom, node2);
        }else{
            res = node2;
            res.bottom = merge(node2.bottom, node1);
        }
        return res;
    }
}