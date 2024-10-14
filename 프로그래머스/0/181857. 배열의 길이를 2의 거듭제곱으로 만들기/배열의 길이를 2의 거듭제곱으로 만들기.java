import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;

        // 현재 길이가 이미 2의 거듭제곱인지 확인
        if ((length & (length - 1)) == 0) {
            return arr; // 이미 2의 거듭제곱이면 그대로 반환
        }

        // 다음 2의 거듭제곱 구하기
        int newLength = 1;
        while (newLength < length) {
            newLength *= 2;
        }

        // 0으로 채운 배열 생성
        int[] result = Arrays.copyOf(arr, newLength);
        
        return result;
    }
}