import java.util.Scanner;

public class CompareVersion {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter version1:");
	String v1=sc.next();
    System.out.println("Enter version2:");
	String v2=sc.next();

    compareVersion1(v1,v2);
    compareVersion2(v1,v2);
    compareVersion3(v1,v2);
}

    private static void compareVersion1(String v1, String v2) {

        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();

        for(int i=0;i<v1.length();i++) {
            if(v1.charAt(i)!='.') {
              s1.append(v1.charAt(i));
              s2.append(v2.charAt(i));
            }
        }

        if(Integer.parseInt(s1.toString())<Integer.parseInt(s2.toString()))
        System.out.println("Upgrade");
        else if(Integer.parseInt(s1.toString())>Integer.parseInt(s2.toString()))
        System.out.println("Downgrade");
        else
        System.out.println("equal");
    }


    public static void compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 < num2) {
                 System.out.println("Upgrade");
            } else if (num1 > num2) {
                System.out.println( "Downgrade");
            }
        }
        
        
    }

    public static void compareVersion3(String version1, String version2) {
        if (version1.compareTo(version2) < 0) 
            System.out.println("Upgrade");
        else if (version1.compareTo(version2) > 0) 
            System.out.println( "Downgrade");
        else
        System.out.println("equal");
    }

}
