import java.util.Scanner;

class Node {
    int data;
    Node next;
 public Node right;
 public Node left; 
    Node(int data) {
     this.data=data;
    }
 }
 
 class LinkedlistInsert {
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
 
     public int conversio1() {
        Node temp=head;
        String s="";
        while(temp!=null) {
            s+=temp.data;
            temp=temp.next;
        }

        int sum=0;
        int n=s.length();
        for(int i=s.length()-1;i>=0;i--) { 
            sum+=Math.pow(2,n-1-i)*(s.charAt(i)-'0');
            
    }
        
        return sum;
    }


   
        public int conversion2() {
            int sum = 0;
            Node temp = head;
            
            while (temp != null) {
                sum = sum * 2 + temp.data; 
                temp = temp.next;
            }
            
            return sum;
        }
 }
public class BinaryNumberToInteger {
   
   
    public static void main(String[] args) {
    LinkedlistInsert l=new LinkedlistInsert();

    Scanner sc=new Scanner(System.in);
    
    System.out.println("Enter number of elemnts in LinkedList");
    int n=sc.nextInt();
    System.out.println("Enter elemnts:");
    for(int i=0;i<n;i++)
    {
        int data=sc.nextInt();
        l.insert(data);
    }

     int res1=l.conversio1();
     System.out.println(res1);

     int res2=l.conversion2();
     System.out.println(res2);
    }
}