
/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k){
        int length=0;
        Node temp = node;
        while(temp!=null){
            temp = temp.next;
            length++;
        }
        
        Node curr = node;
        Node prevOldHead = null;
        Node res = null;
        
        for(int i=1; i<=length; i+=k){
            Node head = curr;
            for(int j=i;; j++){
                if((j==i+k-1) || (j==length)){
                    Node tempHead = curr.next;
                    curr.next = null;
                    Node currNewHead = reverseGeneric(head);
                    if(prevOldHead!=null) prevOldHead.next = currNewHead;
                    prevOldHead = head;
                    if(j==k) res = currNewHead;
                    curr = tempHead;
                    break;
                }
                curr = curr.next;
            }
        }
        
        return res;
    }
    
    private static Node reverseGeneric(Node node){
        Node prev = null;
        Node curr = node;
        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}