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

    public void insert(int element) {
        Node n=new Node(element);

        if(head==null) {
            head=n;tail=n;
        }

        tail.next=n;
        tail=n;
    }

    public boolean SearchElement(int search) {
        Node temp=head;

        while(temp!=null) {
            if(temp.val==search)
            return true;

            temp=temp.next;
        }

        return false;
    }

}
public class SearchLinkedList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedListClass l=new LinkedListClass();
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int i=0;
        while(i<n) {
            int element=sc.nextInt();
            l.insert(element);
            i++;
        }

        System.out.println("Enter search element:");
        int search=sc.nextInt();

        boolean res=l.SearchElement(search);
        if(res)
        System.out.println(search+" element present");
        else
        System.out.println(search+" element NOT present");
    }
}