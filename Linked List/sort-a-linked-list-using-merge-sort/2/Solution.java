
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
        if(head==null || head.next==null) return head;
        Node mid = findMid(head);
        Node left = head, right = mid.next;
        mid.next = null;
        return merge(mergeSort(left), mergeSort(right));
    }
    
    private static Node merge(Node left, Node right){
        if(left==null) return right;
        if(right==null) return left;
        Node merged = new Node(-1);
        Node curr = merged;
        while(left!=null && right!=null){
            if(left.data<=right.data){
                curr.next = left;
                left = left.next;
            }
            else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left!=null?left:right;
        return merged = merged.next;
    }
    
    private static Node findMid(Node node){
        Node slow = node, fast = node.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
