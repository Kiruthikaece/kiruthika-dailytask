import java.util.Scanner;

class Node {
    Node next;
    int data;
    Node(int data) {
        this.data=data;
    }
}

class LinkedList {
   
    Node head,tail;
    public void insert(int data) {
    Node n=new Node(data);
    if(head==null) {
        head=n;
        tail=n;
    }
    else {
        tail.next=n;
        tail=n;
    }
   }
    public int findLength1() {
         Node temp=head;
         int count=0;
         while(temp!=null) {
            count++;
            temp=temp.next;
         }
         return count;
    }
    public int findLength2() {
        return getLength(head);
    }
    private int getLength(Node head2) {
          if(head2==null)
          return 0;

          return 1+getLength(head2.next);
    }
   

}
public class LinkedListLength {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        LinkedList l=new LinkedList();
        int i=0;
        while(i<n) {
            int x=sc.nextInt();
            l.insert(x);
            i++;
        }

        int res1=l.findLength1();
        System.out.println("Length of the linkedlist:"+res1);

        int res2=l.findLength2();
        System.out.println("Length of the linkedlist:"+res2);
    }
}
 