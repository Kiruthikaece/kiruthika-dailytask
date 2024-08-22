import java.util.*;


public class SortPeople {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter height array length");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter heights:");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        String[] names=new String[n];
        System.out.println("Enter names array:");
        for(int i=0;i<n;i++)
        names[i]=sc.next();

        // String[] res1=sortPeople1(arr,names);
        // System.out.println(Arrays.toString(res1));

        // String[] res2=sortPeople2(arr,names);
        // System.out.println(Arrays.toString(res2));

        String[] res3=sortPeople3(arr,names);
        System.out.println(Arrays.toString(res3));
    }

    private static String[] sortPeople1(int[] heights, String[] names) {
        for(int i=0;i<heights.length;i++) {
            for(int j=i+1;j<heights.length;j++)
            if(heights[i]<heights[j]) {
                int temp=heights[i];
                heights[i]=heights[j];
                heights[j]=temp;

                String t1=names[i];
                names[i]=names[j];
                names[j]=t1;
            }
        }

        return names;
    }

    private static String[] sortPeople2(int[] arr, String[] names) {
        Map<Integer,String> map=new TreeMap<>();

        for(int i=0;i<arr.length;i++) {
            map.put(arr[i],names[i]);
        }

        int j=names.length-1;

        for(Map.Entry<Integer,String> mpp:map.entrySet()) {
            names[j--]=mpp.getValue();
        }

        return names;
    }

    public static String[] sortPeople3( int[] heights,String[] names) {
        int n = names.length;
        Integer[] idx = new Integer[n];
        for(int i = 0 ; i<n ; i++){
            idx[i] = i; 
        }
        Arrays.sort(idx, new Comparator<Integer>(){
            public int compare(Integer in1 , Integer in2){
                return Integer.compare(heights[in2],heights[in1]);
            }
        });
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = names[idx[i]];
        }
        
        return sortedNames;
    }
}