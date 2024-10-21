import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String[] arr = my_string.toLowerCase().split("");
        Arrays.sort(arr);
        for(String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}