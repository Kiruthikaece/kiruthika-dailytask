import java.util.ArrayList;
import java.util.List;

public class CountSubstring {
    public static void main(String[] args) {
        String s="abcabc";
        int res1=countSubString1(s);
        System.out.println(res1);

        int res2=countSubString2(s);
        System.out.println(res2);
    }

 
    private static int countSubString1(String s) {
         List<String> list=new ArrayList<>();

        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<=s.length();j++) {
                list.add(s.substring(i,j));
            }
        }

        int count=0;

        for(String li:list) {
            System.out.print(li+"  ");
            if(li.contains("a") && li.contains("b") && li.contains("c"))
            count++;
        }

        return count;
    }
    public static int countSubString2(String s) {
        int aTot = 0, bTot = 0, cTot = 0;
        int res = 0;
        int i = 0, j = 0;
    
        while (j < s.length()) {
            if (s.charAt(j) == 'a') aTot++;
            else if (s.charAt(j) == 'b') bTot++;
            else if (s.charAt(j) == 'c') cTot++;
                while (aTot > 0 && bTot > 0 && cTot > 0) {
                res += s.length() - j;
    
                if (s.charAt(i) == 'a') aTot--;
                else if (s.charAt(i) == 'b') bTot--;
                else if (s.charAt(i) == 'c') cTot--;
                
                i++;
            }
            
            j++; 
        }
        return res;
    
    }
}