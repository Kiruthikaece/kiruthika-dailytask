import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PlusOne {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
	int[] res1=plusOne1(arr);
    System.out.println(Arrays.toString(res1));

    // int[] res2=plusOne2(arr);
    // System.out.println(Arrays.toString(res2));

    // int[] res3=plusOne3(arr);
    // System.out.println(Arrays.toString(res3));
    
}

    private static int[] plusOne1(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }
            arr[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static int[] plusOne2(int[] digits) {
        return plusOneHelper(digits, digits.length - 1);
    }

    private static int[] plusOneHelper(int[] digits, int index) {
        if (index < 0) {
            int[] newNumber = new int[digits.length + 1];
            newNumber[0] = 1;
            return newNumber;
        }

        if (digits[index] < 9) {
            digits[index]++;
            return digits;
        }

        digits[index] = 0;
        return plusOneHelper(digits, index - 1);
    }


     public static int[] plusOne3(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            stack.push(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            stack.push(carry);
        }

        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }
}
