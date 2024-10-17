class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int[] alpha = new int[26];
        for(char c : s.toCharArray()) {
            alpha[c - 97]++;
        }
        for(int i = 0; i < alpha.length; i++) {
            if(alpha[i] == 1) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}