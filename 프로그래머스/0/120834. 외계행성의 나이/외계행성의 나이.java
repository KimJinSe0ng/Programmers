class Solution {
    public String solution(int age) {
        StringBuilder result = new StringBuilder();
        
        String ageStr = String.valueOf(age);
        
        for (char digit : ageStr.toCharArray()) {
            result.append((char) (digit - '0' + 'a'));
        }
        
        return result.toString(); 
    }
}