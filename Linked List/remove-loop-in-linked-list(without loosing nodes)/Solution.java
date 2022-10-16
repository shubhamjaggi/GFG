
/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        Node slow, fast;
        slow = fast = head;
        Node prev = null;
        
        while(slow!=null && fast!=null && fast.next!=null){
            Node temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){ //loop present
                prev = temp;
                break;
            }
        }
        
        if(slow!=fast){ //no loop present
            return;
        }
        
        Node toBeTail = prev;
        
        Node ptrComingFromHead = head;
        Node ptrComingFromLoop = slow;
        while(ptrComingFromHead!=ptrComingFromLoop){
            ptrComingFromHead = ptrComingFromHead.next;
            toBeTail = ptrComingFromLoop;
            ptrComingFromLoop = ptrComingFromLoop.next;
        }
        
        toBeTail.next = null;
    }
}