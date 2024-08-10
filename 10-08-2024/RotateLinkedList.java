import java.util.Scanner;

class DNode {
    int data;
    DNode next; 
    DNode(int data) {
     this.data=data;
    }
 }
 
 class LinkedListClass {
     DNode head,tail;
     public void insert(int data) {
         DNode n=new DNode(data);
         if(head==null) {
             head=n;
             tail=n;
         }
         else {
             tail.next=n;
             tail=n;
         }
     }

     public void display() 
     {
         DNode temp=head;
         while(temp!=null)
         {
             System.out.print(temp.data+" ");
             temp=temp.next;
         }
         System.out.println();
     }



     void rotate(int k) {

         DNode last = head; 
         DNode temp = head; 
           
         if (head == null || k == 0) { 
             return; 
         } 
         while (last.next != null) { 
             last = last.next; 
         } 
         while (k != 0) { 
             head = head.next; 
             temp.next = null; 
             last.next = temp; 
             last = temp; 
             temp = head; 
             k--; 
         } 
     } 
   
     void push(int new_data) 
     { 
         
         DNode new_node = new DNode(new_data);  
         new_node.next = head; 
         head = new_node; 
     } 
   
 }
public class RotateLinkedList {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

        LinkedListClass l=new LinkedListClass();
        System.out.println("Enter number of elemnts in LinkedList");
        int n=sc.nextInt();
        System.out.println("Enter elemnts:");
         for(int i=0;i<n;i++)
         {
        int data=sc.nextInt();
        l.insert(data);
         }

         l.rotate(3);

        l.display();
    }
}

