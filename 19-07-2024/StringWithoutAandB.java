import java.util.Scanner;

public class StringWithoutAandB {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a:");
        int a=sc.nextInt();
        System.out.println("Enter b:");
        int b=sc.nextInt();
        String res1=generateString1(a,b);
        System.out.println("Smallest String:"+res1);
        String res2=generateString2(a,b);
        System.out.println("Smallest String:"+res2);
        String res3=generateString3(a,b);
        System.out.println("Smallest String:"+res3);
      
    }

    public static String generateString1(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            if (a > b) {
                if (a >= 2) {
                    sb.append("aa");
                    a -= 2;
                } else if (a == 1) {
                    sb.append("a");
                    a--;
                }
                if (b > 0) {
                    sb.append("b");
                    b--;
                }
            } else {
                if (b >= 2) {
                    sb.append("bb");
                    b -= 2;
                } else if (b == 1) {
                    sb.append("b");
                    b--;
                }
                if (a > 0) {
                    sb.append("a");
                    a--;
                }
            }
        }
        return sb.toString();
    }

    private static String generateString2(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int maxCount = Math.max(a, b);
        int minCount = Math.min(a, b);
        char maxChar = a >= b ? 'a' : 'b';
        char minChar = a >= b ? 'b' : 'a';

        while (maxCount > 0 || minCount > 0) {
            if (maxCount > 0) {
                sb.append(maxChar);
                maxCount--;
            }
            if (maxCount > 0) {
                sb.append(maxChar);
                maxCount--;
            }
            if (minCount > 0) {
                sb.append(minChar);
                minCount--;
            }
        }
        return sb.toString();
    }
    public static String generateString3(int a, int b) {
        return generateStringUseRecursion(a, b, new StringBuilder(), ' ');
    }

    private static String generateStringUseRecursion(int a, int b, StringBuilder sb, char lastChar) {
        if (a == 0 && b == 0) {
            return sb.toString();
        }
        if (a > 0 && (sb.length() < 2 || sb.charAt(sb.length() - 1) != 'a' || sb.charAt(sb.length() - 2) != 'a')) {
            sb.append('a');
            return generateStringUseRecursion(a - 1, b, sb, 'a');
        }
        if (b > 0 && (sb.length() < 2 || sb.charAt(sb.length() - 1) != 'b' || sb.charAt(sb.length() - 2) != 'b')) {
            sb.append('b');
            return generateStringUseRecursion(a, b - 1, sb, 'b');
        }
        return sb.toString();
    }

}
