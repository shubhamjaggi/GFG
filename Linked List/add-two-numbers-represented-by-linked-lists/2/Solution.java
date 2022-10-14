
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        Node node1 = getReversedLinkedList(first);
        Node node2 = getReversedLinkedList(second);
        
        Node node1Head = node1;
        int carry = 0;
        Node last = null;
        
        while(node1!=null && node2!=null){
            node1.data = node1.data + node2.data + carry;
            carry = node1.data>=10?(node1.data/10):0;
            node1.data%=10;
            last = node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        
        if(node1==null && node2==null){
            if(carry!=0){
                last.next = new Node(carry);
            }
        }
        else{
            Node remNode = node1!=null?node1:node2;
            Node remNodeHead = remNode;
            Node lastRemNode = null;
            while(remNode!=null){
                remNode.data = remNode.data + carry;
                carry = remNode.data>=10?(remNode.data/10):0;
                remNode.data%=10;
                lastRemNode = remNode;
                remNode = remNode.next;
            }
            if(carry!=0){
                lastRemNode.next = new Node(carry);
            }
            last.next=remNodeHead;
        }
        return getReversedLinkedList(node1Head);
    }
    
    private static Node getReversedLinkedList(Node head){
        Node node = head;
        Node prev = null;
        while(node!=null){
            Node temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}