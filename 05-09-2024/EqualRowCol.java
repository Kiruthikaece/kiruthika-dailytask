import java.util.Arrays;
import java.util.HashMap;

public class EqualRowCol {
    public static void main(String[] args) {
        int[][] mat={{3,2,1},{1,7,6},{2,7,7}};
        int res1=findEqualRowCols1(mat);
        System.out.println(res1);

        int res2=findEqualRowCols2(mat);
        System.out.println(res2);

        int res3=findEqualRowCols3(mat);
        System.out.println(res3);
    }

    private static int findEqualRowCols1(int[][] grid) {
        int count=0;
        int n=grid.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                  boolean isequal=true;
                for(int l=0;l<n;l++) 
                if(grid[i][l] != grid[l][j]) {
                isequal=false;
                break;
               }

               if(isequal)  
                count++;
            }
           
        }

        return count;
    }

    private static int findEqualRowCols2(int[][] grid) {
        int m = grid[0].length;
    
        int[][] transpose = new int[m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                transpose[j][i] = grid[i][j];
            }
        }
        int ans = 0;
        for(int[] row : grid){
            for(int[] col : transpose){
                if(Arrays.equals(row, col)) ans++;
            }
        }
        return ans;
    }

    public static int findEqualRowCols3(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, int[]> r = new HashMap<>();
        HashMap<Integer, int[]> c = new HashMap<>();
        for(int i = 0; i < n; i++){
            r.put(i, grid[i]);
        }
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = grid[j][i];
            }
            c.put(i, column);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(Arrays.equals(r.get(i), c.get(j))){
                    count++;
                }
            }
        }
        return count;
    }
}