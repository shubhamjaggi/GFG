
//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int N, Node head){
        Node evenTail = null;
        Node oddTail = null;
        
        Node evenHead = null;
        Node oddHead = null;
        
        Node curr = head;
        
        while(curr!=null){
            if (curr.data%2==0){
                if (evenHead == null){
                    evenHead = evenTail = curr;
                }
                else{
                    evenTail.next = curr;
                    evenTail = curr;
                }
            }else{
                if (oddHead == null){
                    oddHead = oddTail = curr;
                }
                else{
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }
            curr = curr.next;
        }
        
        if(oddTail==null){
            if (evenTail == null){
                return null;
            }
            else{
                return evenHead;
            }
        }else{
            oddTail.next = null;
            if (evenTail == null){
                return oddHead;
            }
            else{
                evenTail.next = oddHead;
                return evenHead;
            }
        }
    }
}