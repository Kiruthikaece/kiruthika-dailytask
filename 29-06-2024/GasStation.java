import java.util.Scanner;

public class GasStation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of gas station:");
        int n=sc.nextInt();
        int[]  gas=new int[n];
        int[] cost=new int[n];
        System.out.println("Enter gas tank:");
        for(int i=0;i<n;i++)
        gas[i]=sc.nextInt();
        System.out.println("Enter cost:");
        for(int i=0;i<n;i++)
        cost[i]=sc.nextInt();

        int ans1=canCompleteCircuit1(gas,cost);
        System.out.println(ans1);
        int ans2=canCompleteCircuit2(gas,cost);
        System.out.println(ans2);
        int ans3=canCompleteCircuit3(gas,cost);
        System.out.println(ans3);
    }

    //soln-1
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int tank = 0;
            boolean canComplete = true;
            for (int i = 0; i < n; i++) {
                int currentIndex = (start + i) % n;
                tank += gas[currentIndex] - cost[currentIndex];
                if (tank < 0) {
                    canComplete = false;
                    break;
                }
            }
            if (canComplete) {
                return start;
            }
        }
        return -1;
    }

//soln-2
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }
        
        return totalTank >= 0 ? startStation : -1;
    }

//soln-3
    public static int canCompleteCircuit3(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int start = 0, tank = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return totalGas >= totalCost ? start : -1;
    }
}
