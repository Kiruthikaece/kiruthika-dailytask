class Node  {
    int data;
    Node next;
    Node(int data) {
        this.data=data;
    }
}


public class ReorderList {
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);

        reOrderLL(head);
        printLL(head);
    }

    private static void printLL(Node head) {
       Node temp=head;

       while(temp!=null) {
        System.out.print(temp.data+" ");
        temp=temp.next;
       }
    }

    private static void reOrderLL(Node head) {
        if (head == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        Node first = head;
        Node second = prev;
        while (second.next != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            first = temp1;

            second.next = first;
            second = temp2;
        }
    }
}
