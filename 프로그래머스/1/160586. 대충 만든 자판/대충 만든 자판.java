import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> mKey = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        //1.각 알파벳 별 최소 키를 저장
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char k = key.charAt(i);
                
                if(!mKey.containsKey(k)) {
                    mKey.put(k, i + 1);
                } else {
                    mKey.put(k, Math.min(mKey.get(k), i + 1));
                }
            }
        }
        
        for(String target : targets) {
            int sum = 0;
            boolean hasKey = true;
            
            for(int i = 0; i < target.length(); i++) {
                char t = target.charAt(i);
                
                if(!mKey.containsKey(t)) {
                    hasKey = false;
                    break;
                }
                sum += mKey.get(t);
            }
            
            if(hasKey) {
                result.add(sum);
            } else {
                result.add(-1);
            }
        }
        // for (Map.Entry<Character, Integer> e : mKey.entrySet()) {
        //     System.out.println("Key: " + e.getKey() + ", Value: " + e.getValue());
        // }
        return result.stream().mapToInt(i -> i).toArray();
    }
}