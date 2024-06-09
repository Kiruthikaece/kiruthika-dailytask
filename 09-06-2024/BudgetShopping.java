import java.util.*;

class BudgetShopping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter budgets");
        int b = sc.nextInt();
		System.out.println("Enter number of keyboards");
        int n = sc.nextInt();
		System.out.println("Enter number of models");
        int m = sc.nextInt();
		
		System.out.println("Enter keyboards");
        int[] keyboards = new int[n];
        for (int i = 0; i < n; i++) {
            keyboards[i] = sc.nextInt();
        }
		System.out.println("Enter models");
        int[] drives = new int[m];
        for (int i = 0; i < m; i++) {
            drives[i] = sc.nextInt();
        }
		findMaxAmount1(b,n,m,keyboards,drives);
		findMaxAmount2(b,n,m,keyboards,drives);
		findMaxAmount3(b,n,m,keyboards,drives);
	}
	
	// soln-1
	public static void findMaxAmount1(int b,int n,int m,int[] keyboards,int[] drives) {
        int maxAmount = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int totalCost = keyboards[i] + drives[j];
                if (totalCost <= b && totalCost > maxAmount) {
                    maxAmount = totalCost;
                }
            }
        }
        System.out.println("Maximum amount:"+maxAmount);
    }
	
	// soln-2
	public static void findMaxAmount2(int b,int n,int m,int[] keyboards,int[] drives) {
		
		Arrays.sort(keyboards);
         Arrays.sort(drives);
		  int maxAmount = -1;
		  
		   int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {
            int totalCost = keyboards[i] + drives[j];
            if (totalCost > b) {
                j--;  
            } else {
                if (totalCost > maxAmount) {
                    maxAmount = totalCost;
                }
                i++;
            }
        }

        System.out.println("Maximum amount:"+maxAmount);
	}
	
	//soln-3
	public static void findMaxAmount3(int b,int n,int m,int[] keyboards,int[] drives) {
		
		HashSet<Integer> possibleSums = new HashSet<>();
		
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                int totalCost = keyboard + drive;
                if (totalCost <= b) {
                    possibleSums.add(totalCost);
                }
            }
        }
        int maxAmount = -1;
        for (int sum : possibleSums) {
            if (sum > maxAmount) {
                maxAmount = sum;
            }
        }
        System.out.println("Maximum amount:"+maxAmount);
	}
}
