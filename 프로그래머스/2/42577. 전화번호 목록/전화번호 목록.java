import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for(String phone : phone_book) {
            map.put(phone, map.getOrDefault(phone, 0) + 1);
        }
        
        for (String phone : phone_book) {
            // System.out.println("---");
            for (int i = 1; i < phone.length(); i++) {
                // System.out.println("phone = " + phone);
                if (map.containsKey(phone.substring(0, i))) {
                    return false; 
                }
            }
        }
        
        return true;
    }
}