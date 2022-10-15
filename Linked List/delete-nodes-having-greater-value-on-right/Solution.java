
/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        Node curr = head;
        if(curr==null){
            return curr;
        }
        Node otherHead = compute(curr.next);
        if (otherHead!=null && curr.data<otherHead.data){
            return otherHead;
        }
        else{
            curr.next = otherHead;
            return curr;
        }
    }
}