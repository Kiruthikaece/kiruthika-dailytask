import java.util.Scanner;

public class AlternateGroups {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter arr:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int res=countAlternatingGroups1(arr);
        System.out.println(res);
        int res2=countAlternatingGroups2(arr);
        System.out.println(res2);
        int res3=countAlternatingGroups3(arr);
        System.out.println(res3);
    }

    //soln-1
    public static int countAlternatingGroups1(int[] colors) {
        int n = colors.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[(i + 1) % n] && colors[(i + 1) % n] != colors[(i + 2) % n]) {
                count++;
            }
        } 
        return count;
    }

    //soln-2
    public static int countAlternatingGroups2(int[] colors) {
        int n = colors.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int first = colors[i];
            int second = colors[(i + 1) % n];
            int third = colors[(i + 2) % n];
            
            if (first != second && second != third) {
                count++;
            }
        }
        
        return count;
    }

    //soln-3
    public static int countAlternatingGroups3(int[] colors) {
        int n = colors.length;
        int[] extendedColors = new int[2 * n];
        System.arraycopy(colors, 0, extendedColors, 0, n);
        System.arraycopy(colors, 0, extendedColors, n, n);
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (extendedColors[i] != extendedColors[i + 1] && extendedColors[i + 1] != extendedColors[i + 2]) {
                count++;
            }
        }
        
        return count;
    }
}