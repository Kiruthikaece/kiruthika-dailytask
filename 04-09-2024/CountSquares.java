public class CountSquares {
    public static void main(String[] args) {
        int a=2;
        int b=9;
        int res1=countSquares1(a,b);
        System.out.println(res1);

        int res2=countSquares2(a,b);
        System.out.println(res2);
    }

    private static int countSquares1(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                count++;
            }
        }
        return count;
    }

    private static int countSquares2(int a, int b) {
        int start = (int) Math.ceil(Math.sqrt(a));
        int end = (int) Math.floor(Math.sqrt(b));
        return (start > end) ? 0 : (end - start + 1);
    }
}
