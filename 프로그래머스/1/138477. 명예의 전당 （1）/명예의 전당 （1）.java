import java.util.*;

class Solution {
    public int[] solution(int k, int[] scores) {
        List<Integer> honor = new ArrayList<>();
        List<Integer> publish = new ArrayList<>();
        
        for(int score : scores) {
            honor.add(score);
            
            Collections.sort(honor, (o1, o2) -> o2 - o1);
            if(honor.size() > k) {
                honor.remove(honor.size() - 1);
            }
            
            publish.add(honor.get(honor.size() - 1));
        }
        
        return publish.stream().mapToInt(i -> i).toArray();
    }
}