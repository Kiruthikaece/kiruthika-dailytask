class Node {
    Node next;
    int val;
    Node(int val) {
        this.val=val;
    }
}

public class MergeNodes {
   
    public static void main(String[] args) {
           Node head=new Node(0);
           head.next=new Node(3);
           head.next.next=new Node(1);
           head.next.next.next=new Node(0);
           head.next.next.next.next=new Node(4);
           head.next.next.next.next.next=new Node(5);
           head.next.next.next.next.next.next=new Node(2);
           head.next.next.next.next.next.next.next=new Node(0);

           Node res=mergeNode(head);
           PrintLL(res);

       }

    private static Node mergeNode(Node head) {
           Node temp=head.next;

           Node res=new Node(0);
           Node tail=res;
           int sum=0;

           while(temp!=null) {
               if(temp.val==0) {
                    tail.next=new Node(sum);
                    tail=tail.next;
                    sum=0;
               }
               sum+=temp.val;
               temp=temp.next;
           }

           return res.next;
    }

    private static void PrintLL(Node res) {
          Node temp=res;
          while(temp!=null) {
            System.out.print(temp.val+" ");
            temp=temp.next;
          }

    }
}
