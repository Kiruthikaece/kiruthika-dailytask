import java.util.Arrays;

public class Construct2DArray {
 public static void main(String[] args) {
        int[][] mat=construct2D1(new int[]{1,2,3,4},2,2);

        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++)
            System.out.print(mat[i][j]+" ");
            System.out.println();
        }
       

        int[][] mat1=construct2D2(new int[]{1,2,3,4},2,2);
       
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++)
            System.out.print(mat1[i][j]+" ");
            System.out.println();
        }
       

        int[][] mat2=construct2D3(new int[]{1,2,3,4},2,2);
       
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++)
            System.out.print(mat2[i][j]+" ");
            System.out.println();
        }
       
    }

private static int[][] construct2D1(int[] original,int m,int n) {
    int[][] res=new int[m][n];

    if(m*n!=original.length)
    return new int[0][0];

    int row=0,col=0,k=0;
    for(int i=0;i<m;i++) {
      col=0;
      for(int j=0;j<n;j++)  {
          if(k<original.length) {
              res[row][col]=original[k++];
              col++;
          } 
      }
      row++;
    }

    return res;
}

public static int[][] construct2D2(int[] original, int m, int n) {
    if (original.length != m * n) {
        return new int[0][0];
    }

    int[][] ans = new int[m][n];

    for (int i = 0; i < original.length; i++) {
        ans[i / n][i % n] = original[i];
    }

    return ans;
}

public static int[][] construct2D3(int[] original, int m, int n) {
    if(m*n != original.length){
        return new int[0][0];
    }
    int[][] arr = new int[m][];

    for(int i=0; i<m; i++){
       arr[i] = Arrays.copyOfRange(original, i*n, i*n+n);
    }
    return arr;
}
}