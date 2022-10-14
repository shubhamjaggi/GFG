
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        Node resHead = new Node(-1);//dummyNode
        Node res = resHead;
        while (head1!=null && head2!=null){
            if (head1.data<head2.data){
                head1=head1.next;
            }
            else if(head2.data<head1.data){
                head2=head2.next;
            }
            else{
                res.next = new Node(head1.data);
                res = res.next;
                head1=head1.next;
                head2=head2.next;
            }
        }
        return resHead.next;
    }
}