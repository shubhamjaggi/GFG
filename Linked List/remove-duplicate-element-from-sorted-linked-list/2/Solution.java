
/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head){
        Node curr = head;
        
        while(curr!=null){
            Node temp = curr;
            while(temp.next!=null && temp.next.data==curr.data){
                temp = temp.next;
            }
            curr.next = temp.next;
            curr = curr.next;
        }
        
        return head;
    }
}