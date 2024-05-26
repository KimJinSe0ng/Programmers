import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> answer = new ArrayList<>();
        for (int num = 1; num <= n; num++) {
            if(num % k == 0) {
                answer.add(num);
            }
        }
        return answer.stream()
	                .mapToInt(Integer::intValue)
    	            .toArray();
    }
}