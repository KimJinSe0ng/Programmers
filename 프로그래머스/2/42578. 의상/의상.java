import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 의상 종류별로 몇 개의 의상이 있는지 세는 해시맵
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        // 각 의상을 해시맵에 종류별로 카운트
        for (String[] cloth : clothes) {
            String type = cloth[1]; // 의상의 종류
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        // 경우의 수 계산
        int answer = 1;
        for (int count : clothesMap.values()) {
            answer *= (count + 1); // 해당 종류의 의상을 입지 않는 경우까지 포함
        }
        
        // 아무 의상도 입지 않는 경우는 제외
        return answer - 1;
    }
}