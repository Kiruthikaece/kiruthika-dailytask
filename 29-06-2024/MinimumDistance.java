import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MinimumDistance {
     public static void  main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter list size:");
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        System.out.println("Enter list:");
        for(int i=0;i<n;i++)
        list.add(sc.nextInt());
        int ans1=findMinimumDistance1(list);
        System.out.println("Minimum distance:"+ans1);
        int ans2=findMinimumDistance2(list);
        System.out.println("Minimum distance:"+ans2);
        int ans3=findMinimumDistance3(list);
        System.out.println("Minimum distance:"+ans3);
    }

    //soln-1
    public static int findMinimumDistance1(List<Integer> list) {
          int minDistance=Integer.MAX_VALUE;
          for(int i=0;i<list.size();i++) {
            for(int j=i+1;j<list.size();j++) {
                if(list.get(i).equals(list.get(j)))
                minDistance=Math.min(minDistance,j-i);
            }
          }

          return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    //soln-2
    public static int findMinimumDistance2(List<Integer>list) {
        int minDistance=Integer.MAX_VALUE;
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<list.size();i++) {
            int element=list.get(i);
            if(map.containsKey(list.get(i))) {
                minDistance=Math.min(minDistance,i-map.get(element));
            }
            map.put(element,i);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    //soln-3
    public static int findMinimumDistance3(List<Integer> a) {
        int n = a.size();
        int maxElement =10000; 
        int[] lastSeen = new int[maxElement + 1];
        Arrays.fill(lastSeen, -1);
        int minDis = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int element = a.get(i);
            if (lastSeen[element] != -1) {
                minDis = Math.min(minDis, i - lastSeen[element]);
            }
            lastSeen[element] = i;
        }
        
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}



