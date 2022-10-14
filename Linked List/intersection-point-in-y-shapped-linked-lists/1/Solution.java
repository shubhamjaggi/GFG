
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2){
	    Node node1 = head1;
	    Node node2 = head2;
	    while(true){
	        if(node1==node2){
	            return node1.data;
	        }
	        node1 = node1.next;
	        node2 = node2.next;
	        node1 = node1==null?head2:node1;
	        node2 = node2==null?head1:node2;
	    }
	}
}
