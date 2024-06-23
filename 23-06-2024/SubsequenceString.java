import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SubsequenceString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENter string:");
        String str=sc.next();
        List<String> li1=subsequence1(str);
        System.out.println(li1);
        subsequence2(0,str," ");
    }

    private static void subsequence2(int i,String s,String f) {
        if (i == s.length()) {
            System.out.print(f+" ");
            return;
        }
        subsequence2(i + 1, s,  f+s.charAt(i));
        subsequence2(i + 1, s,  f);
    }

    private static List<String>  subsequence1(String s) {
      	int n = s.length();
	    List<String>ans=new ArrayList<>();
	for (int num = 0; num < (1 << n); num++) {
		String sub = "";
		for (int i = 0; i < n; i++) {
			if ((num & (1 << i))!=0) {
				sub += s.charAt(i);
			}
		}
		if (sub.length() > 0) {
			ans.add(sub);
		}
	}
	Collections.sort(ans);
	return ans;
}
}