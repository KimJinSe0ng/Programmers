import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < intStrs.length; i++) {
            int part = Integer.parseInt(intStrs[i].substring(s, s + l));
            if(part > k) {
                answer.add(part);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}