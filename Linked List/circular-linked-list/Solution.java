
/* Structure of LinkedList
class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/
class GfG
{
    boolean isCircular(Node head){
        if (head==null) return true;
        Node curr = head;
        while(curr!=null){
            if(head==curr.next){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}