import java.util.*;
class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < my_str.length(); i++) {
            sb.append(my_str.charAt(i));
            if(sb.length() == n) {
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        if(sb.length() != 0) {
            list.add(sb.toString());
        }
        return list.toArray(new String[0]);
    }
}