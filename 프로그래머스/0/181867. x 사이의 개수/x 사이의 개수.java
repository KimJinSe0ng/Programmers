import java.util.*;

class Solution {
    public int[] solution(String myString) {
        // "x"를 기준으로 문자열을 분리
        String[] parts = myString.split("x", -1); // -1을 사용하면 끝에 빈 문자열도 포함됨
        System.out.println(Arrays.toString(parts));
        
        // 각 부분 문자열의 길이를 저장할 배열 생성
        int[] lengths = new int[parts.length];
        
        // 각 부분 문자열의 길이를 배열에 저장
        for (int i = 0; i < parts.length; i++) {
            lengths[i] = parts[i].length();
        }
        
        return lengths;
    }
}