import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        List<Integer> arr = new ArrayList<>();
        for(int num : numbers) {
            arr.add(num);
        }
        
        int sum = 0;
        
        for(int i = 0; i <= 9; i++) {
            if(!arr.contains(i)) {
                sum += i;
            }
        }
        
        return sum;
    }
}