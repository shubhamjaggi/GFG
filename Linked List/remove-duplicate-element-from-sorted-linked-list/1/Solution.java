
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
        if(head==null || head.next==null) return head;
        
        Node curr, prev;
        
        if(head.data == head.next.data){
            head.next = head.next.next;
            prev = head;
            curr = head.next;
        }else{
            prev = head.next;
            curr = head.next.next;
        }
        
        while(curr!=null){
            if(curr.data==prev.data){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        
        return head;
    }
}