import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        // "l" 또는 "r"이 나오는 첫 번째 위치를 찾기
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                // "l"이 나오면 왼쪽 부분 반환 (0부터 i-1까지)
                return Arrays.copyOfRange(str_list, 0, i);
            } else if (str_list[i].equals("r")) {
                // "r"이 나오면 오른쪽 부분 반환 (i+1부터 끝까지)
                return Arrays.copyOfRange(str_list, i + 1, str_list.length);
            }
        }
        
        // "l" 또는 "r"이 없으면 빈 배열 반환
        return new String[]{};
    }
}