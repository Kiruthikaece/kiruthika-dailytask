


import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data=data;
    }
}
class LinkedlistClass {
    Node head,tail;

    public void add(int element) {
        Node n=new Node(element);
        if(head==null) {
            head=n;
            tail=n;
        }
        tail.next=n;
        tail=n;
    }

   

    public void display() {
        Node t=head;
        while(t!=null) {
            System.out.print(t.data+" ");
            t=t.next;
        }
    }

    void reverseLL() {
         
          Node pre=null;
          Node current=head;

          while(current!=null) {
            Node temp = current.next;
            current.next = pre;
            pre=current;
            current=temp;
          }

          head=pre;
    }


}
public class ReverseLL {
    public static void main(String[] args) {

         Scanner sc=new Scanner(System.in);
         LinkedlistClass l=new LinkedlistClass();
         System.out.println("Enter n");
         int n=sc.nextInt();
         int i=0;
         
         while(i<n) {
            int element=sc.nextInt();
            l.add(element);
            i++;
         }

         System.out.println("Before Reverse:");
         l.display();

         l.reverseLL();
         
         System.out.println("\nAfter Reverse:");
         l.display();

        
    }
}
