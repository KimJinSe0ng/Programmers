class Solution {
    public int solution(String myString, String pat) {
         StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < myString.length(); i++) {
            char current = myString.charAt(i);
            if (current == 'A') {
                sb.append('B');
            } else if (current == 'B') {
                sb.append('A');
            }
        }
        
        if (sb.toString().contains(pat)) {
            return 1;
        } else {
            return 0;
        }
    }
}