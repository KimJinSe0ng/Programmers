import java.util.*;

class Solution {
    
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerIndexMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }

        for (String called : callings) {
            int currentIndex = playerIndexMap.get(called); 
            int previousIndex = currentIndex - 1;        

            String previousPlayer = players[previousIndex];
            players[previousIndex] = called;
            players[currentIndex] = previousPlayer;

            playerIndexMap.put(called, previousIndex);
            playerIndexMap.put(previousPlayer, currentIndex);
        }

        return players;
    }
}