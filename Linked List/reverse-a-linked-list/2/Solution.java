
//function Template for Java

/* linked list node class:

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        Node newHead = reverseRecursive(head);
        head.next = null;
        return newHead;
    }
    
    private Node reverseRecursive(Node node){
        if(node.next==null){
            return node;
        }
        Node head = reverseRecursive(node.next);
        node.next.next = node;
        return head;
    }
}