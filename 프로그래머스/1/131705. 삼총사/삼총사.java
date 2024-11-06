class Solution {
    public int solution(int[] number) {
        int totalStudent = number.length;
        int count = 0;
        
        for(int i = 0; i < totalStudent; i++) {
            int sum = 0;
            
            for(int j = i + 1; j < totalStudent; j++) {
                for(int k = j + 1; k < totalStudent; k++) {
                    sum = number[i] + number[j] + number[k];
                    
                    if(sum == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}