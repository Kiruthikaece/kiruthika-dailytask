import java.util.Scanner;
import java.util.Stack;

class  Node {
    Node next;
    int data;
    Node(int data) {
        this.data=data;
    }
}


class Linkedlist {
    Node head,tail;

    public void insert(int data) {
        Node n=new Node(data);

        if(head==null) {
            head=n;
            tail=n;
        }

        tail.next=n;
        tail=n;
    }

    public boolean isPalindrome() {

       Node pre=null;
       Node current=head;

       while(current!=null) {
        Node next=current.next;
        current.next=pre;
        pre=current;
        current=next;
       }

       Node temp=head;

       while(pre!=null && temp!=null) {
            if(temp.data!=pre.data)
            return false;
            temp=temp.next;
            pre=pre.next;
       }

       return true;

    }

    public boolean isPalindrome2(Node head) {
        Stack<Integer> stack=new Stack<>();
        Node t=head;
        while(t!=null) {
            stack.push(t.data);
            t=t.next;
        }
         Node t1=head;
        while(t1!=null) {
            if(t1.data!=stack.pop())
            return false;
            t1=t1.next;
        }
        return true;
    }

}


public class PalindromeLL {
    public static void main(String[] args) {
        Linkedlist l=new Linkedlist();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();

        int i=0;

        while(i<n) {
            int element=sc.nextInt();
            l.insert(element);
            i++;
        }

        boolean res=l.isPalindrome();
        if(res)
        System.out.println("Is palindrome");
        else
        System.out.println("Is not a Palindrome");

    }
}