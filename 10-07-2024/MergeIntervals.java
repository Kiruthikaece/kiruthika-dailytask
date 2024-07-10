import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> intervals = new ArrayList<>();

        System.out.println("Enter number of intervals:");
        int n = scanner.nextInt();

        System.out.println("Enter intervals:");
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new int[]{start, end});
        }
        List<int[]> res1 = mergeIntervals1(intervals.toArray(new int[intervals.size()][]));
        System.out.println("Merged intervals:");
        for (int[] interval : res1) {
            System.out.println(Arrays.toString(interval));
        }
        
        List<int[]> res2=mergeIntervals2(intervals.toArray(new int[intervals.size()][]));
        System.out.println("Merged intervals:");
        for (int[] interval : res2) {
            System.out.println(Arrays.toString(interval));
        }
    }

   
      public static List<int[]> mergeIntervals1(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return result;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }

        return result;
    }

    public static List<int[]> mergeIntervals2(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return result;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();

        for (int[] interval : intervals) {
            if (stack.isEmpty() || stack.peek()[1] < interval[0]) {
                stack.push(interval);
            } else {
                stack.peek()[1] = Math.max(stack.peek()[1], interval[1]);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        Collections.reverse(result); 
        return result;
    }
    }

    
