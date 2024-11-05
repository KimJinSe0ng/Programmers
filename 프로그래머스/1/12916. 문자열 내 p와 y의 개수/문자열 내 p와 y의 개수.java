class Solution {
    boolean solution(String s) {
        String S = s.toLowerCase();
        int p = 0;
        int y = 0;
        
        for(char c : S.toCharArray()) {
            if(c == 'p') {
                p++;
            } else if(c == 'y') {
                y++;
            }
        }

        return (p == y) ? true : false;
    }
}