import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        Map<String, Integer> miss = new HashMap<>();
        List<Integer> scores = new ArrayList<>();
        
        for(int i = 0; i < name.length; i++) {
            miss.put(name[i], yearning[i]);
        }
        
        for(String[] photo : photos) {
            int sum = 0;
            
            for(String n : photo) {
                if(miss.containsKey(n)) {
                    sum += miss.get(n);
                }
            }
            
            scores.add(sum);
        }
        return scores.stream().mapToInt(i -> i).toArray();
    }
}