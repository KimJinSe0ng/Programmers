class Solution {
    public int solution(String s) {
        int count = 0; 
        int i = 0;
        
        while (i < s.length()) {
            char x = s.charAt(i); 
            int xCount = 0; 
            int otherCount = 0;
            
            while (i < s.length()) {
                if (s.charAt(i) == x) {
                    xCount++;
                } else {
                    otherCount++;
                }
                i++; 
                
                if (xCount == otherCount) {
                    count++;
                    break;
                }
            }
            
            if (i == s.length() && xCount != otherCount) {
                count++;
            }
        }
        
        return count;
    }
}

//x: b(1), a(1) -> ba
//x: n(1), a(1) -> na
//x: n(1), a(1) -> na