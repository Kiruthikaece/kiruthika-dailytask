
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data=data;
    }
}
class Linkedlist {
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

    public void deleteNode(int del) {


        if(head.data==del)
        head=head.next;
        
        else {
            Node pre=null;
            Node temp=head;

            while(temp!=null) {
                if(temp.data==del) 
                pre.next=temp.next;
                pre=temp;
                temp=temp.next;
            }
            
        }
         
    }

    public void display() {
        Node t=head;
        while(t!=null) {
            System.out.print(t.data+" ");
            t=t.next;
        }
    }

   


}
public class DeleteLL {
    public static void main(String[] args) {

         Scanner sc=new Scanner(System.in);
         Linkedlist l=new Linkedlist();
         System.out.println("Enter n");
         int n=sc.nextInt();
         int i=0;
         
         while(i<n) {
            int element=sc.nextInt();
            l.add(element);
            i++;
         }
        
         System.out.println("Enter delete node:");
         int del=sc.nextInt();

         System.out.println("Before deleting:");
         l.display();
         l.deleteNode(del);
         System.out.println("\nAfter deleting:");
         l.display();

        
    }
}