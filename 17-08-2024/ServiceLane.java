
import java.util.Arrays;

public class ServiceLane {
    public static void main(String[] args) {
        int n=4;
        int[] width={2,3,2,1};
        int[][] cases={{1,2},{2,3}};
        int[] res1=serviceLane1(n,width,cases);
        System.out.println(Arrays.toString(res1));

        int[] res2=serviceLane2(n,width,cases);
        System.out.println(Arrays.toString(res2));
    }

    public  static int[] serviceLane1(int n, int[] width, int[][] cases) {
        int[] result = new int[cases.length];

        for (int i = 0; i < cases.length; i++) {
            int entry = cases[i][0];
            int exit = cases[i][1];
            int minWidth = Integer.MAX_VALUE;

            for (int j = entry; j <= exit; j++) { 
                minWidth = Math.min(minWidth, width[j]);
            }
            result[i] = minWidth;
        }

        return result;
    }


    public static int[] serviceLane2(int n, int[] width, int[][] cases) {
        int[] result = new int[cases.length];
        int[] minWidth = new int[n];

        for (int i = 0; i < n; i++) {
            minWidth[i] = width[i];
            if (i > 0) {
                minWidth[i] = Math.min(minWidth[i], minWidth[i - 1]);
            }
        }

        for (int i = 0; i < cases.length; i++) {
            int entry = cases[i][0];
            int exit = cases[i][1];
            if (exit >= n) {
                exit = n - 1;  
            }
            result[i] = minWidth[exit];
            if (entry > 0) {
                result[i] = Math.min(result[i], minWidth[entry - 1]);
            }
        }

        return result;
    }
}
