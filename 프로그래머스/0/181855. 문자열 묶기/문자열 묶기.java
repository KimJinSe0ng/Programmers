import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        HashMap<Integer, Integer> lengthMap = new HashMap<>();
        
        for (String str : strArr) {
            int length = str.length(); 
            
            lengthMap.put(length, lengthMap.getOrDefault(length, 0) + 1);
        }
        
        int maxGroupSize = 0;
        for (int size : lengthMap.values()) {
            maxGroupSize = Math.max(maxGroupSize, size);
        }
        
        return maxGroupSize;
    }
}