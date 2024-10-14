import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> deleteSet = new ArrayList<>();
        for (int num : delete_list) {
            deleteSet.add(num);
        }

        List<Integer> resultList = new ArrayList<>();
        
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                resultList.add(num);
            }
        }
        
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}