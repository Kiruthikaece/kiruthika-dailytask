import java.util.Scanner;

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data=data;
    }
}

class LinkedListCC {

    Node head,tail;
    
    
    public void insert(int element) {
      Node n=new Node(element);

      if(head==null) {
        head=n;
        tail=n;
      }

      tail.next=n;
      tail=n;
    }

    void printLL() {
        Node temp=head;
 
        while(temp!=null) {
         System.out.print(temp.data+" ");
         temp=temp.next;
        }
     }


    public Node deleteMiddleNode() {
       
        if(head==null || head.next==null)
        return null;
        
         Node slow=head;
         Node fast=head;
         Node prev=null;

         while(fast!=null && fast.next!=null) {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
         }

         prev.next=prev.next.next;

         return head;
    }
}

public class DeleteMiddleNode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedListCC l=new LinkedListCC();
        System.err.println("Enter n:");
        int n=sc.nextInt();
        int i=0;
        while(i<n) {
            int element=sc.nextInt();
            l.insert(element);
            i++;
        }

        System.out.println("\nBefore deletion:");
        l.printLL();
        l.deleteMiddleNode();
        System.out.println("\nAfter deletion:");
        l.printLL();

    }
}
