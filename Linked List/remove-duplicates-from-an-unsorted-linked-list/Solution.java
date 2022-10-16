
/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
        if(head==null || head.next==null) return head;
        
        Set<Integer> nums = new HashSet<>();
        
        Node curr = head;
        Node prev = null;
        
        while(curr!=null){
            if(nums.contains(curr.data)){
                prev.next = curr.next;
            }else{
                prev = curr;
                nums.add(curr.data);
            }
            curr = curr.next;
        }
        
        return head;
    }
}