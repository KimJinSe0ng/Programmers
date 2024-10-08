import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            for(int j = s; j <= e; j++) {
                result.add(arr[j]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}