
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
        
        Node head = new Node(-1);//dummyHead
        Node res = head;
        int carry = 0;
        
        while(node1!=null && node2!=null){
            int data = node1.data + node2.data + carry;
            carry = data>=10?(data/10):0;
            data%=10;
            res.next = new Node(data);
            node1 = node1.next;
            node2 = node2.next;
            res=res.next;
        }
        
        Node remNode = node1!=null?node1:node2;
        
        while(remNode!=null){
            int data = remNode.data + carry;
            carry = data>=10?(data/10):0;
            data%=10;
            res.next = new Node(data);
            remNode = remNode.next;
            res=res.next; 
        }
        
        if(carry!=0){
            res.next = new Node(carry);
        }
        
        return getReversedLinkedList(head.next);
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