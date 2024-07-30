import java.util.*;

public class RearrangeCharacters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String s=sc.next();
        System.out.println("Enter target:");
        String t=sc.next();
        int res1=rearrangeCharcters1(s,t);
        System.out.println(res1);
        int res2=rearrangeCharcters2(s,t);
        System.out.println(res2);

    }

    private static int rearrangeCharcters1(String s, String target) {
        Map<Character,Integer> sMap=new HashMap<>();
        Map<Character,Integer> tMap=new HashMap<>();

        for(int i=0;i<s.length();i++)
        sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);

       for(int i=0;i<target.length();i++)
        tMap.put(target.charAt(i),tMap.getOrDefault(target.charAt(i),0)+1);

           int res=Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> mpp:tMap.entrySet()) {

           char c=mpp.getKey();
           int y=mpp.getValue();
           if(!sMap.containsKey(c))
           return 0;

           int x=sMap.get(c);

           res=Math.min(res,(x/y));
           
               
           
        }

           return res;
    }


    public static int rearrangeCharcters2(String s, String target) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt1[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < target.length(); ++i) {
            ++cnt2[target.charAt(i) - 'a'];
        }
        int ans = 100;
        for (int i = 0; i < 26; ++i) {
            if (cnt2[i] > 0) {
                ans = Math.min(ans, cnt1[i] / cnt2[i]);
            }
        }
        return ans;
    }
}