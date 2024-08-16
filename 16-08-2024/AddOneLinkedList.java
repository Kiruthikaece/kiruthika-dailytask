class Node {
    Node next;
    int data;
    Node(int data) {
        this.data=data;
    }
}


public class AddOneLinkedList {
    public static void main(String[] args) {
        Node head=new Node(9);
        head.next=new Node(9);
        head.next.next=new Node(9);
         head=AddOne(head);
        printLL(head);
    }

    private static Node  AddOne(Node head) {
        head=reverseList(head);
        Node temp=head;
        Node pre=null;
        int carry=1;

        while(temp!=null) {
            int sum=temp.data+carry;
            carry=sum/10;
            temp.data=sum%10;
            pre=temp;
            temp=temp.next;
        }
        
        if(carry>0)
        pre.next=new Node(carry);

        head=reverseList(head);
        
        return head;
    }

    private static void printLL(Node head) {
       Node temp=head;

       while(temp!=null) {
        System.out.print(temp.data+" ");
        temp=temp.next;
       }
    }

    public static Node reverseList(Node head) {
        Node pre=null;
        Node current=head;
        
        while(current!=null) {
            Node next=current.next;
            current.next=pre;
            pre=current;
            current=next;
        }
        
        return pre;
    }
}