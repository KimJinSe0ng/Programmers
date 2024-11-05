class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(Long.toString(n));
        sb.reverse();
        
        String s = sb.toString();
        String[] S = s.split("");
        
        int[] answer = new int[S.length];
        
        for(int i = 0 ; i < S.length; i++) {
            answer[i] = Integer.parseInt(S[i]);
        }
        
        return answer;
    }
}