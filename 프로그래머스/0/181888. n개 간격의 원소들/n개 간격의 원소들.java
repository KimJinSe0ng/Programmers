import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> A = new ArrayList<>();
        
        int i = 0;
        
        while(i < num_list.length) {
            A.add(num_list[i]);
            i += n;
        }
        
        return A.stream().mapToInt(Integer::intValue).toArray();
    }
}