import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < my_string.length(); i++) {
            arr.add(my_string.substring(i));
        }
        
        if(arr.contains(is_suffix)) {
            return 1;
        } else {
            return 0;
        }
    }
}