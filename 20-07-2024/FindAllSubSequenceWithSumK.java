import java.util.*;

public class FindAllSubSequenceWithSumK {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
    System.out.println("Enter Sum:");
    int k=sc.nextInt();
	findAllSubsequence1(arr,0,new ArrayList<>(),k,0);
    System.err.println();
    findAllSubsequence2(arr,k);
    System.err.println();
    findAllSubsequence3(arr,k);
}

    private static void findAllSubsequence1(int[] arr,int index,List<Integer> list,int sum,int total) {
        if(index==arr.length) {
            if(total==sum) {
                System.out.print(list);
            }
            return;
        }


        list.add(arr[index]);
        total+=arr[index];
        findAllSubsequence1(arr,index+1,list,sum,total);
        list.remove(list.size()-1);
        total-=arr[index];
        findAllSubsequence1(arr,index+1,list,sum,total);
    }

    private static void findAllSubsequence2(int[] arr, int sum) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0, 0});
        List<Integer> current = new ArrayList<>();

        while (!stack.isEmpty()) {
            int[] state = stack.pop();
            int index = state[0];
            int total = state[1];
            int size = state[2];

            while (current.size() > size) {
                current.remove(current.size() - 1);
            }

            if (index == arr.length) {
                if (total == sum) {
                    System.out.print(current);
                }
                continue;
            }

            stack.push(new int[]{index + 1, total, current.size()});
            current.add(arr[index]);
            stack.push(new int[]{index + 1, total + arr[index], current.size()});
        }
    }

    private static void findAllSubsequence3(int[] arr, int sum) {
        int n = arr.length;
        int totalSubsequences = 1 << n;

        for (int mask = 0; mask < totalSubsequences; mask++) {
            List<Integer> subsequence = new ArrayList<>();
            int total = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsequence.add(arr[i]);
                    total += arr[i];
                }
            }

            if (total == sum) {
                System.out.print(subsequence);
            }
        }
    }
}
