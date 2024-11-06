class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length();
        
        String masked = "*".repeat(length - 4);
        
        return masked + phone_number.substring(length - 4);
    }
}