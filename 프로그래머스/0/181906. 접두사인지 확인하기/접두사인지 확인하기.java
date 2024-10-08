import java.util.*;

class Solution {
    public int solution(String my_string, String is_prefix) {
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < my_string.length(); i++) {
            arr.add(my_string.substring(0, i));
        }
        if(arr.contains(is_prefix)) {
            return 1;
        } else {
            return 0;
        }
    }
}