import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> answer = new HashSet<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if(i == j) {
                    continue;
                }
                
                answer.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> result = new ArrayList<>(answer);
        
        Collections.sort(result);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}