class Solution {
    public int solution(String[] s1, String[] s2) {
        int cnt = 0;
        for(String s1Word : s1) {
            for(String s2Word : s2) {
                if(s1Word.equals(s2Word)) cnt ++;
            }
        }
        return cnt;
    }
}