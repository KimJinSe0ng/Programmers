import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(!list.contains(arr[i]) && list.size() < k) {
                list.add(arr[i]);
            }
        }
        
        if(list.size() < k) {
            int len = list.size();
            for(int i = 0; i < k - len; i++) {
                list.add(-1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}