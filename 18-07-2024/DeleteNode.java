
import java.util.Scanner;

class Node {
    Node next;
    int val;
    Node(int val) {
        this.val=val;
    }
}
class LinkedListClass {
    Node head,tail;

    public void insert(int data) {
        Node n=new Node(data);

        if(head==null) {
            tail=n;
            head=n;
        }
       
        tail.next=n;
        tail=n;
    }

    public void DeleteNode(int data) {
        Node temp=head;
        Node prev=null;

        if(head.val==data)
        head=head.next;
        while(temp!=null) {

            if(temp.val==data)
            prev.next=temp.next;

            prev=temp;
            temp=temp.next;
        }
    }

    public void printLL() {
        Node temp=head;
        while(temp!=null) {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
public class DeleteNode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedListClass l=new LinkedListClass();

        System.out.println("Enter number of nodes:");
        int n=sc.nextInt();
        int i=0;
        while(i<n) {
            int element=sc.nextInt();
            l.insert(element);
            i++;
        }

        System.out.println("Enter Delete node:");
        int deleteNode=sc.nextInt();
        System.out.println("Before Deletion:");
        l.printLL();
       l.DeleteNode(deleteNode);
       System.out.println("After Deletion:");
       l.printLL();
       

    }
}
