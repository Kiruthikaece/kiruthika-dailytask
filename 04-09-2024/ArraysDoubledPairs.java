import java.util.Map;
import java.util.TreeMap;

public class ArraysDoubledPairs {
    public static void main(String[] args) {
        int[] arr={4,-2,2,-4};
        boolean res1=canReorderDoubled1(arr);
        System.out.println(res1);

        boolean res2=canReorderDoubled2(arr);
        System.out.println(res2);
    }

    public static boolean canReorderDoubled1(int[] arr) {

        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : arr)
            count.put(a, count.getOrDefault(a, 0) + 1);
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0))
                return false;
            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }

    public static boolean canReorderDoubled2(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) {
            if (map.get(n) > 0) {
                if (n < 0 && n % 2 != 0) return false;

                int target = n < 0 ? n / 2 : n * 2;

                if (map.get(n) > map.getOrDefault(target, 0)) {
                    return false;
                }

                map.put(target, map.get(target) - map.get(n));
            }
        }

        return true;
    }
}
