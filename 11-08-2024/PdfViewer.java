import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PdfViewer {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

	System.out.println("Enter string:");
    String str=sc.next();

    List<Integer> list = new ArrayList<>(List.of(
        1, 3, 1, 3, 1, 4, 1, 3, 2, 
        5, 5, 5, 5, 5, 5, 5, 5, 5, 
        5, 5, 5, 5, 5, 5, 5
    ));


	
	int res1=pdfViewer1(str,list);
    System.out.println(res1);
	int res2=pdfViewer2(str,list);
    System.out.println(res2);

}

    private static int pdfViewer1(String word, List<Integer> list) {
        
        int max=0;
        int n=word.length();
        
        for(int i=0;i<n;i++) {
            int ele=(word.charAt(i)-'a');
            if(list.get(ele)>max)
            max=list.get(ele);
        }
        
        
        return n*max;
    }

    public static int pdfViewer2(String word, List<Integer> list) {
        int maxHeight = 0;
        for (char c : word.toCharArray()) {
            int height = list.get(c - 'a');
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxHeight * word.length();
    }
}
