class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;
        
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) { //공백이면
                sb.append(c);
                toUpper = true; //공백문자 다음은 대문자
            } else {
                if (toUpper) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        
        return sb.toString();
    }
}