
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
	    int length1 = 0, length2 = 0;
	    while(node1!=null){
	        node1 = node1.next;
	        length1++;
	    }
	    while(node2!=null){
	        node2 = node2.next;
	        length2++;
	    }
	    int diff = length1-length2;
	    node1 = head1;
	    node2 = head2;
	    if(diff>0){
	        for(int i=0; i<diff; i++){
	            node1 = node1.next;
	        }
	    }else if(diff<0){
	        diff = -diff;
	        for(int i=0; i<diff; i++){
	            node2 = node2.next;
	        }
	    }
	    while(node1!=null && node2!=null){
	        node1 = node1.next;
	        node2 = node2.next;
	        if(node1==node2){
	            return node1.data;
	        }
	    }
	    return -1;
	}
}
