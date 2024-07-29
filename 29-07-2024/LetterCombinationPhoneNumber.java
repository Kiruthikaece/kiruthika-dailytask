import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
	    System.out.println("Enter Digit:");
	    String digit=sc.next();
        String[] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String>res1=Combination1(digit,arr);
        System.out.println(res1);

        List<String>res2=Combination2(digit,arr);
        System.out.println(res2);
    }


    public static List<String> Combination1(String digits,String[] KEYPAD) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0,KEYPAD);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, String digits, int index,String[] KEYPAD) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, current, digits, index + 1,KEYPAD);
            current.deleteCharAt(current.length() - 1);
        }
    }

public static List<String> Combination2(String digits,String[] KEYPAD) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        for (int i = 0; i < digits.length(); i++) {
            String letters = KEYPAD[digits.charAt(i) - '0'];
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String combination = queue.poll();
                for (char c : letters.toCharArray()) {
                    queue.add(combination + c);
                }
            }
        }

        result.addAll(queue);
        return result;
    }

}
