
import java.util.*;

public class SortArray {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
	System.out.println("Enter array length:");
	int n=sc.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter array:");
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();
    int[] res1=sortArray1(arr);
    System.out.println(Arrays.toString(res1));

    int[] res2=sortArray2(arr);
    System.out.println(Arrays.toString(res2));

    }

    private static int[] sortArray1(int[] nums) {
       
        Map<Integer,Integer> map=new HashMap<>();

           for(int i=0;i<nums.length;i++)
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);


            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey(); 
            } else {
                return a.getValue() - b.getValue(); 
            }
        });


          int[] result = new int[nums.length];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                result[k++] = entry.getKey();
            }
        }

        return result;
    }

    public static int[] sortArray2(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int value = entry.getKey();
            int frequency = entry.getValue();
            sortedMap.computeIfAbsent(frequency, k -> new ArrayList<>()).add(value);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
            List<Integer> values = entry.getValue();
            Collections.sort(values, Collections.reverseOrder());
            for (int value : values) {
                for (int i = 0; i < entry.getKey(); i++) {
                    result.add(value);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}