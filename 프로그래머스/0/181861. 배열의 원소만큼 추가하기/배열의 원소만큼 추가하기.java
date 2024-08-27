import java.util.*;

class Solution {
    private static List<Integer> A = new ArrayList<>();
    
    public int[] solution(int[] arr) {
        for(int num : arr) {
            for(int i = 0; i < num; i++) {
                A.add(num);
            }
        }
        return A.stream().mapToInt(Integer::intValue).toArray();
    }
}