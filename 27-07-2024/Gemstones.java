import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Gemstones {
    public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
	System.out.println("Enter number of String:");
	int n=sc.nextInt();
    String[] arr=new String[n];

    for(int i=0;i<n;i++)
    arr[i]=sc.next();

    int res1=maxOperation1(arr);
    System.err.println(res1);
    int res2=maxOperation2(arr);
    System.err.println(res2);


    int res3=maxOperation3(arr);
    System.err.println(res3);
}

    private static int maxOperation1(String[] arr) {
         Set<Character> gemstones = new HashSet<>();
        for (char c : arr[0].toCharArray()) {
            gemstones.add(c);
        }

        for (int i = 1; i < arr.length; i++) {
            Set<Character> currentRock = new HashSet<>();
            for (char c : arr[i].toCharArray()) {
                currentRock.add(c);
            }
            gemstones.retainAll(currentRock);
        }

        return gemstones.size();
    }

    public static int maxOperation2(String[] arr) {
        int[] frequency = new int[26];
        int numRocks = arr.length;

        for (String rock : arr) {
            boolean[] seen = new boolean[26];
            for (char c : rock.toCharArray()) {
                if (!seen[c - 'a']) {
                    frequency[c - 'a']++;
                    seen[c - 'a'] = true;
                }
            }
        }

        int gemstoneCount = 0;
        for (int count : frequency) {
            if (count == numRocks) {
                gemstoneCount++;
            }
        }

        return gemstoneCount;
    }

    public static int maxOperation3(String[] arr) {
        int[] mineralPresence = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (char c : arr[i].toCharArray()) {
                mineralPresence[i] |= (1 << (c - 'a'));
            }
        }

        int allRocksMask = (1 << 26) - 1;
        for (int mask : mineralPresence) {
            allRocksMask &= mask;
        }

        return Integer.bitCount(allRocksMask);
    }
}
