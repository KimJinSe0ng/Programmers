import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < flag.length; i++) {
            if(flag[i] == true) {
                for(int j = 0; j < arr[i]; j++) {
                    list.add(arr[i]);
                    list.add(arr[i]);
                }
            } else {
                for(int k = 0; k < arr[i]; k++) {
                    list.remove(list.size() - 1);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}