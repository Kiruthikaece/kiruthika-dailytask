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
     
     public void insert(int data) {
         Node n=new Node(data);
         if(head==null)
         {
             head=n;
             tail=n;
         }
         else{
             tail.next=n;
             tail=n;
         }
     }

    public void findMiddleLL1() {
        Node temp=head;
        int count=0;
        while(temp!=null) {
            temp=temp.next;
            count++;
        }

        Node temp1=head;
        for(int i=0;i<count/2;i++)
        temp1=temp1.next;

        while(temp1!=null) {
            System.out.print(temp1.data+" ");
            temp1=temp1.next;
        }
    }

    void findMiddleLL2() {
       Node fast=head;
       Node slow=head;

       while(fast!=null && fast.next!=null && slow!=null) {
        fast=fast.next.next;
        slow=slow.next;
       }

       while(slow!=null) {
        System.out.print(slow.data+" ");
        slow=slow.next;
       }
    }

    }

public class MiddleLinkedList {
    public static void main(String[] args) {
        Linkedlist l=new Linkedlist();
        Scanner sc=new Scanner(System.in);
    
    System.out.println("Enter number of elemnts in LinkedList");
    int n=sc.nextInt();
    System.out.println("Enter elemnts:");
    for(int i=0;i<n;i++)
    {
        int data=sc.nextInt();
        l.insert(data);
    }
    l.findMiddleLL1();
    System.out.println();
    l.findMiddleLL2();
    
    }
}
