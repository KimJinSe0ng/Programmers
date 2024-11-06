class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        
        for(int num = left; num <= right; num++) {
            sum += calculate(num);
        }
        
        return sum;
    }
    
    private int calculate(int num) {
        int count = 0;
        
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                count++;
            }
        }
        
        if(count % 2 == 1) {
            return num * -1;
        }
        
        return num;
    }
}