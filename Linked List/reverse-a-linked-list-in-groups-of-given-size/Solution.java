
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
        if(k==1){
            return node;
        }
        Node resultHead = node;
        Node prevSublistOrigHead = null;
        Node currSublistOrigHead = null;
        
        Node curr = node;
        int count=1;
        Node nextSublistOrigHead = curr;
        
        while(nextSublistOrigHead!=null){
            prevSublistOrigHead = currSublistOrigHead;
            currSublistOrigHead = nextSublistOrigHead;
            while(true){
                count++;
                curr = count%k==1?nextSublistOrigHead:curr.next;
                if(count%k==0 || curr.next==null){
                    nextSublistOrigHead = curr.next;
                    curr.next = null;
                    Node currSublistNewHead = reverseGeneric(currSublistOrigHead);
                    if (prevSublistOrigHead!=null){
                        prevSublistOrigHead.next = currSublistNewHead;
                    }
                    if(count==k){
                        resultHead = currSublistNewHead;
                    }
                    break;
                }
            }
        }
        return resultHead;
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