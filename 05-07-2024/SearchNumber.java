import java.util.Scanner;

public class SearchNumber {
    public static void main(String[] args ) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter m:");
        int m=sc.nextInt();
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("Enter matrix:");
        int[][] mat=new int[m][n];

        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        mat[i][j]=sc.nextInt();
        System.out.println("Enter number:");
        int no=sc.nextInt();

        boolean res1=isNumberPresent1(mat,no);
        System.out.println(res1);

        boolean res2=isNumberPresent2(mat,no);
        System.out.println(res2);

        boolean res3=isNumberPresent3(mat,no);
        System.out.println(res3);
    }

    private static boolean isNumberPresent2(int[][] mat, int no) {
        int row=mat.length,col=mat[0].length;
        int i=0,j=col-1;
        while(i<row &&j>=0)  {
            int mid=mat[i][j];
            if(mid==no)
            return true;
            else if(mid<no)
            i++;
            else 
            j--;
        }
        return false;
    }

    public static boolean isNumberPresent1(int[][] mat,int no) {
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat.length;j++) {
                if(mat[i][j]==no)
                return true;
            }
        }

        return false;
    }

    public static boolean isNumberPresent3(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
        int low=0,high=(r*c-1);
        while(low<=high){
           int mid=low+(high-low)/2;
            int row=mid/c,col=mid%c;
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                low=mid+1;
            }
            else high=mid-1;
        }
        return false;
    }
}
