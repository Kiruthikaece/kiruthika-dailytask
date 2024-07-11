import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AssignCookies {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

	System.out.println("Enter child length:");
	int n=sc.nextInt();
    System.out.println("Enter child:");
	int[] g=new int[n];
    for(int i=0;i<n;i++)
	g[i]=sc.nextInt();

    System.out.println("Enter cookie length:");
	int m=sc.nextInt();
    System.out.println("Enter cookie:");
	int[] l=new int[m];
	for(int i=0;i<n;i++)
	l[i]=sc.nextInt();

	int res1=AssignCookies1(g,l);
    System.out.println("Longest Subarray with sum:"+res1);
    int res2=AssignCookies2(g,l);
    System.out.println("Longest Subarray with sum:"+res2);

    int res3=AssignCookies3(g,l);
    System.out.println("Longest Subarray with sum:"+res3);
}


public static int AssignCookies3(int[] g, int[] s) {
        PriorityQueue<Integer> children = new PriorityQueue<>();
        PriorityQueue<Integer> cookies = new PriorityQueue<>();

        for (int greed : g) {
            children.offer(greed);
        }
        for (int size : s) {
            cookies.offer(size);
        }

        int contentChildren = 0;

        while (!children.isEmpty() && !cookies.isEmpty()) {
            if (cookies.peek() >= children.peek()) {
                contentChildren++;
                children.poll();
            }
            cookies.poll();
        }

        return contentChildren;
    }


    private static int AssignCookies2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0; 
        int j = 0;  
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;  
            }
            j++;
        }
        return i;
    }

    private static int AssignCookies1(int[] g, int[] s) {
      Arrays.sort(g);
      Arrays.sort(s);

      int count=0,l=0,r=0;

      while(l<g.length && r<s.length) {

        int child=g[l],cookie=s[r];
        if(child>cookie)
        r++;
        if(child<=cookie) {
            count++;
            l++;
            r++;
        }

       
      }
       return count;
    }


}
