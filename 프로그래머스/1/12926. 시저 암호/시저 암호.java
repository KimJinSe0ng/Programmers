class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(push(c, n));
        }
        return sb.toString();
    }
    
    private char push(char c, int n) {
        //알파벳이 아닌 경우 문자를 그대로 이어 붙이기
        if (!Character.isAlphabetic(c)) return c;
        
        //알파벳인 경우 n만큼 밀어 이어 붙이기
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }
}