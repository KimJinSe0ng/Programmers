class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String S1 : s1) {
            for(String S2 : s2) {
                if(S1.equals(S2)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}