import java.util.*;

class Solution {
    public int solution(int[] array) {
        // 1. 숫자의 빈도를 저장할 HashMap 생성
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // 2. 각 숫자의 빈도를 계산
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // 3. 최빈값 찾기
        int maxFrequency = 0;  // 최댓값 빈도
        int mode = -1;         // 최빈값
        boolean isMultiple = false;  // 최빈값이 여러 개인지 확인
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            if (freq > maxFrequency) {
                maxFrequency = freq;
                mode = num;
                isMultiple = false;  // 새로운 최빈값이므로 중복이 아님
            } else if (freq == maxFrequency) {
                isMultiple = true;  // 최빈값이 여러 개일 때
            }
        }
        
        // 4. 최빈값이 여러 개라면 -1 반환
        if (isMultiple) {
            return -1;
        }
        
        return mode;  // 최빈값 반환
    }
}