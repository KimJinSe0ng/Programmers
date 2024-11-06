class Solution {
    public int solution(int num) {
        long number = num;

        if(number == 1) return 0;
        
        for(int i = 1; i <= 500; i++) {
            if(number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            
            if(number == 1) return i;
        }
        
        return -1;
    }
    
}