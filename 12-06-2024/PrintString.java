import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter input string:");
        String str=sc.next();
        PrintCountString1(str);
        System.out.println();
        PrintCountString2(str);
        System.out.println();
        PrintCountString3(str);
    }

    public static void PrintCountString1(String str) {
        int count=1;
        char ch=str.charAt(0);
        for(int i=1;i<str.length();i++) {
            if(ch==str.charAt(i)) {
                count++;
            }
            else {
                System.out.print(ch+""+count);
                count=1;
                ch=str.charAt(i);
            }
        }
        System.out.print(ch+""+count);
    }

    public static void PrintCountString2(String str) {
        int count=1;
        char ch=str.charAt(0);
        StringBuilder result =new StringBuilder();
        
        for(int i =1; i <str.length(); i++) {
            if(ch==str.charAt(i)) {
                count++;
            } else {
                result.append(ch).append(count);
                count = 1;
                ch = str.charAt(i);
            }
        }
        
        result.append(ch).append(count);
        System.out.print(result.toString());
    }

    public static void PrintCountString3(String str) {
        Map<Character,Integer> charCountMap = new LinkedHashMap<>();
        
        for(int i=0; i<str.length();i++) {
            char ch = str.charAt(i);
            charCountMap.put(ch,charCountMap.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : charCountMap.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue());
        }
        
        System.out.print(result.toString());
    } 
}
