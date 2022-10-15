
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
    int getMiddle(Node head){
        int length = 0;
        Node curr = head;
        
        while(curr!=null){
            length++;
            curr = curr.next;
        }
        
        int index = (length/2) + 1;
        
        curr = head;
        
        for(int i=1; i<index; i++){
            curr = curr.next;
        }
        
        return curr.data;
    }
}