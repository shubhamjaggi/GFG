
//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head){
        int length = 0;
        Node curr = head;
        for(;curr!=null;length++)curr=curr.next;
        return sort(head, length);
    }
    
    private static Node sort(Node node, int length){
        if(length==0 || length==1) return node;
        
        int num1,num2;
        
        if(length%2==0){
            num1 = num2 = length/2;
        }
        else{
            num1 = (length/2) + 1;
            num2 = length/2;
        }
        
        Node list1 = node;
        for(int i=1; i<num1; i++){
            node = node.next;
        }
        
        Node list2 = node.next;
        node.next = null;
        
        return merge(sort(list1, num1), sort(list2, num2), num1, num2);
    }
    
    private static Node merge(Node node1, Node node2, int length1, int length2){
        Node head;
        Node tail;
        
        if(node1.data<=node2.data){
            head = tail = node1;
            node1 = node1.next;
            length1--;
        }else{
            head = tail = node2;
            node2 = node2.next;
            length2--;
        }
        
        for(;length1!=0 && length2!=0;){
            if(node1.data<=node2.data){
                tail.next = node1;
                
                node1 = node1.next;
                length1--;
            }
            else{
                tail.next = node2;
                
                node2 = node2.next;
                length2--;
            }
            tail = tail.next;
        }
        
        tail.next = length2==0?node1:node2;
        
        return head;
    }
}
