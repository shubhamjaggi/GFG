
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

class Solution
{
    public static Node addOne(Node head) 
    {
        //code here.
        Node node = reverseLinkedList(head);
        node = addOneUtil(node);
        return reverseLinkedList(node);
    }
    
    private static Node reverseLinkedList(Node head){
        Node nodeLastConsidered = null;
        Node nodeCurrentlyUnderConsideration = head;
        
        while(nodeCurrentlyUnderConsideration!=null){
            Node nodeToBeConsideredInNextIteration = nodeCurrentlyUnderConsideration.next;
            nodeCurrentlyUnderConsideration.next = nodeLastConsidered;
            
            nodeLastConsidered = nodeCurrentlyUnderConsideration;
            nodeCurrentlyUnderConsideration = nodeToBeConsideredInNextIteration;
        }
        
        return nodeLastConsidered;
    }
    
    private static Node addOneUtil(Node head){
        Node nodeLastConsidered = null;
        Node nodeCurrentlyUnderConsideration = head;
        
        int carry = 1;
        while(nodeCurrentlyUnderConsideration!=null){
            nodeCurrentlyUnderConsideration.data+=carry;
            carry = nodeCurrentlyUnderConsideration.data>=10?1:0;
            nodeCurrentlyUnderConsideration.data = nodeCurrentlyUnderConsideration.data%10;
            
            nodeLastConsidered = nodeCurrentlyUnderConsideration;
            nodeCurrentlyUnderConsideration = nodeCurrentlyUnderConsideration.next;
        }
        
        if(carry==1){
            nodeLastConsidered.next = new Node(carry);
        }
        
        return head;
    }
}