

import java.util.Scanner;

class Node {
    Node next;
    int val;
    
    Node(int val) {
        this.val=val;
    }
}

public class LinkedListLLClass {
    Node head,tail;

    public void insert(int data) {
        Node n=new Node(data);

        if(head==null) {
            head=n;tail=n;
        }

        tail.next=n;
        tail=n;
    }

    public void InsertElement(int pos, int element) {

        if(pos==0) {
            Node h=head;
            head=new Node(element);
            head.next=h;
        } else {
            Node temp=head;
            for(int i=0;i<pos-1;i++)
            temp=temp.next;
  
            Node temp2=temp.next;
            Node temp3=new Node(element);
  
            temp.next=temp3;
            temp3.next=temp2;
        }
         
          
    }

    public void printLL() {
        Node temp=head;
        while(temp!=null) {
            System.err.print(temp.val+" ");
            temp=temp.next;
        }
        System.err.println();
    }
}
class LinkedListClass {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedListLLClass l=new LinkedListLLClass();
        System.err.println("Enter n:");
        int n=sc.nextInt();
        int i=0;
        System.err.println("Enter LL:");
        while(i<n) {
            int element=sc.nextInt();
            l.insert(element);
            i++;
        }
        System.out.println("Enter position:");
        int pos=sc.nextInt();
        System.out.println("Enter element:");
        int element=sc.nextInt();

        l.printLL();
        l.InsertElement(pos,element);
        l.printLL();
    }
}