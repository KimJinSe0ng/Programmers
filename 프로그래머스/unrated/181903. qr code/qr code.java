class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        int[] remainder = new int[code.length()];
        for(int i = 0; i < code.length(); i++) {
            remainder[i] = i % q;
            if(remainder[i] == r) {
                answer += code.charAt(i);
            }
        }
        return answer;
    }
}