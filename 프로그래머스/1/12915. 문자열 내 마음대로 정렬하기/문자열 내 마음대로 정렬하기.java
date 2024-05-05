import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) { //s1과 s2의 n번째 문자가 다를 때만 해당 문자로 비교
                return s1.charAt(n) - s2.charAt(n);
            }
            return s1.compareTo(s2); //그 외에는 사전 순 정렬
        });
        return strings;
    }
}