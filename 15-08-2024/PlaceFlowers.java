import java.util.Scanner;

public class PlaceFlowers {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int m=sc.nextInt();
	int[] arr=new int[m];
	System.out.println("Enter array:");
	for(int i=0;i<m;i++)
	arr[i]=sc.nextInt();
    System.out.println("Enter n:");
	int n=sc.nextInt();
    boolean res1=canPlaceFlowers1(arr,n);
    System.out.println(res1);

    boolean res2=canPlaceFlowers2(arr,n);
    System.out.println(res2);

    boolean res3=canPlaceFlowers3(arr,n);
    System.out.println(res3);
    }

    private static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length;i++) {
            if(flowerbed[i]==0) {
            boolean left= i==0 || flowerbed[i-1]==0;
            boolean right= i==flowerbed.length-1 || flowerbed[i+1]==0;

            if(left && right) {
                flowerbed[i]=1;
                n--;
            }
            if(n==0)
            return true;
            }
            
        }
       return n <= 0;
    }

public static boolean canPlaceFlowers2(int[] flowerbed, int n) {

        int length = flowerbed.length;
        int i = 0;
        
        while (i < length) {
            if (flowerbed[i] == 1) 
                i += 2; 
            else {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1; 
                    n--; 
                    i += 2;
                } else {
                    i++; 
                }
            }
            
            if (n == 0) 
                return true; 
        
        }
        
        return false; 
    }

    public static boolean canPlaceFlowers3(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int prev = -1; 

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 1) {
                prev = i;
            } else {
                if ((prev == -1 || i - prev > 1) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    prev = i;
                    n--;
                    
                    if (n == 0) return true;
                }
            }
        }
        
        return n <= 0;
    }
}