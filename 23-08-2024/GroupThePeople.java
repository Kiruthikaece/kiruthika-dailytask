
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {
    public static void main(String[] args) {
        int[] arr={3,3,3,3,3,1,3};
        List<List<Integer>> res1=groupPeople1(arr);
        System.out.println(res1);

        List<List<Integer>> res2=groupPeople2(arr);
        System.out.println(res2);
    }

   public static List<List<Integer>> groupPeople1(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<>());
            map.get(size).add(i);
            if (map.get(size).size() == size) {
                result.add(new ArrayList<>(map.get(size)));
                map.get(size).clear();
            }
        }

        return result;
    }

    public static List<List<Integer>> groupPeople2(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] buckets = new List[groupSizes.length + 1];

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (buckets[size] == null) {
                buckets[size] = new ArrayList<>();
            }
            buckets[size].add(i);

            if (buckets[size].size() == size) {
                result.add(new ArrayList<>(buckets[size]));
                buckets[size].clear();
            }
        }

        return result;
    }

}
