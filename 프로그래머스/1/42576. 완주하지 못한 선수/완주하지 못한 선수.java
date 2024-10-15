import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for(String player : completion) {
            map.put(player, map.get(player) - 1);
        }
        
        for(String player : map.keySet()) {
            if(map.get(player) != 0) {
                return player;
            }
        }
        
        return "";
    }
}