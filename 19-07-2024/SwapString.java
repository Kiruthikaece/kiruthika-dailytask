

import java.util.Scanner;

class SwapString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string:");
        String s=sc.next();
        String res1=smallestLexicographicSwap1(s);
        System.out.println("Smallest String:"+res1);
        String res2=smallestLexicographicSwap2(s);
        System.out.println("Smallest String:"+res2);
      
    }

    public static String smallestLexicographicSwap1(String s) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; ++i) {
            if ((arr[i - 1] & 1) == (arr[i] & 1) && arr[i - 1] > arr[i]) {
                char temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                break;
            }
        }
        return new String(arr);
    }


    public static String smallestLexicographicSwap2(String s) {
        char[] a = s.toCharArray();
	int n = a.length, i=0;
	while(i < n-1) {
		int curr = a[i]-'0', next = a[i+1]-'0';
		boolean flag1 = curr%2==0, flag2 = next%2==0;
		if(flag1==flag2) {
			if(curr > next) {
				char temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
				break;
			}
		}
		i++;
	}

	return new String(a);
    }


    
}