import java.util.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = new StringBuilder()
                .append(my_string)
                .replace(s, s + overwrite_string.length(), overwrite_string)
                .toString();
        return answer;
    }
}