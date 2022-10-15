
/*Node is defined as
class Node
{
    int data; 
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class GfG{
  /*You are required to complete this method */
   public long multiplyTwoLists(Node l1,Node l2){
       
       long val1 = 0;
       long val2 = 0;
       int n = 1000000007;
       
       while(l1!=null){
           val1 = (val1*10 + l1.data)%n;
           l1 = l1.next;
       }
       
       while(l2!=null){
           val2 = (val2*10 + l2.data)%n;
           l2 = l2.next;
       }
       
       return (val1*val2)%n;
   }
}