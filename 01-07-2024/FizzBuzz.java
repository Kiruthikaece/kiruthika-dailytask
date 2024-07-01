import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FizzBuzz {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        List<String> ans1=fizzBuzz1(n);
        System.out.println(ans1);
        List<String> ans2=fizzBuzz2(n);
        System.out.println(ans2);
        List<String> ans3=fizzBuzz3(n);
        System.out.println(ans3);
    }

    //soln-1
    public static List<String> fizzBuzz1(int n) {
         List<String> list=new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(i%3==0 && i%5==0)
            list.add("FizzBuzz");
            else if(i%3==0)
            list.add("Fizz");
            else if(i%5==0)
            list.add("Buzz");
            else
            list.add(i+"");

           
        }
         return list;
    }

    //soln-2
    public static List<String> fizzBuzz2(int n) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            
            answer.add(sb.toString());
        }
        
        return answer;
    }

    //soln-3
     public static List<String> fizzBuzz3(int n) {
        List<String> answer = new ArrayList<>();
        Map<Integer, String> fizzBuzzMap = new HashMap<>();
        
        fizzBuzzMap.put(3, "Fizz");
        fizzBuzzMap.put(5, "Buzz");
        
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (Integer key : fizzBuzzMap.keySet()) {
                if (i % key == 0) {
                    sb.append(fizzBuzzMap.get(key));
                }
            }
            
            if (sb.length() == 0) {
                sb.append(i);
            }
            
            answer.add(sb.toString());
        }
        
        return answer;
    }
}
