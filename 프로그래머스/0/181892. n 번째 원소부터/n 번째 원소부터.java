import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < num_list.length; i++) {
            list.add(num_list[i]);
        }
        
        List<Integer> subList = list.subList(n - 1, list.size());
        return subList.stream().mapToInt(Integer::intValue).toArray();
    }
}