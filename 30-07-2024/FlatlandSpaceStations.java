import java.util.Arrays;

public class FlatlandSpaceStations {
    public static void main(String[] args) {
        int n = 5;
        int[] c = {0, 4};
        System.out.println(maxDistance1(n, c)); 
        System.out.println(maxDistance2(n, c)); 
        System.out.println(maxDistance3(n, c)); 
    }

    public static int maxDistance1(int n, int[] c) {
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            int minDistance = Integer.MAX_VALUE;
            for (int station : c) {
                int distance = Math.abs(station - i);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
            if (minDistance > maxDistance) {
                maxDistance = minDistance;
            }
        }
        return maxDistance;
    }


    public static int maxDistance2(int n, int[] c) {
        Arrays.sort(c);
        int maxDistance = 0;

        
        maxDistance = Math.max(maxDistance, c[0]);

        
        for (int i = 1; i < c.length; i++) {
            int midDistance = (c[i] - c[i - 1]) / 2;
            maxDistance = Math.max(maxDistance, midDistance);
        }

        maxDistance = Math.max(maxDistance, n - 1 - c[c.length - 1]);

        return maxDistance;
    }

    public static int maxDistance3(int n, int[] c) {
        Arrays.sort(c);
        int maxDistance = 0;

        for (int i = 0; i < n; i++) {
            int closestDist = findClosestStation(i, c);
            maxDistance = Math.max(maxDistance, closestDist);
        }

        return maxDistance;
    }

    private static int findClosestStation(int city, int[] stations) {
        int left = 0;
        int right = stations.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (stations[mid] == city) {
                return 0;
            } else if (stations[mid] < city) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int dist1 = (left < stations.length) ? Math.abs(stations[left] - city) : Integer.MAX_VALUE;
        int dist2 = (right >= 0) ? Math.abs(stations[right] - city) : Integer.MAX_VALUE;

        return Math.min(dist1, dist2);
    }
}
