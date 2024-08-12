import java.util.Scanner;

public class CelebraityProblem {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in); 
    System.out.println("Enter length:");
	int n=sc.nextInt();
	int[][] mat=new int[n][n];
	System.out.println("Enter matix:");
	for(int i=0;i<n;i++)
	for(int j=0;j<n;j++)
    mat[i][j]=sc.nextInt();

    int res1=findcelebraity1(mat);
    System.out.println(res1);

    int res2=findcelebraity2(mat);
    System.out.println(res2);

    int res3=findcelebraity3(mat);
    System.out.println(res3);
    
    }

    private static int findcelebraity1(int[][] mat) {
        int cele=0;
        int n=mat.length;

        for(int i=0;i<n;i++)
        if(mat[cele][i]==1)
        cele=i;

        for(int i=0;i<n;i++) {
            if(i!=cele)
            if(mat[cele][i]!=0 || mat[i][cele]!=1)
            return -1;
        }
        

        return cele;
    }


    public static int findcelebraity2(int[][] M) {

        int N=M.length;
        int i = 0, j = N - 1;
    
        while (i < j) {
            if (M[i][j] == 1) {
                i++; 
            } else {
                j--; 
            }
        }
    
        int candidate = i;
    
        for (int k = 0; k < N; k++) {
            if (k != candidate && (M[candidate][k] == 1 || M[k][candidate] == 0)) {
                return -1;
            }
        }
    
        return candidate;
    }
    
    public static int findcelebraity3(int[][] M) {
        int N=M.length;
        for (int i = 0; i < N; i++) {
            boolean isCelebrity = true;
            for (int j = 0; j < N; j++) {
                if (i != j && (M[i][j] == 1 || M[j][i] == 0)) {
                    isCelebrity = false;
                    break;
                }
            }
            if (isCelebrity) {
                return i;
            }
        }
        return -1;
    }
    
}
