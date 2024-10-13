class Solution {
    public int solution(int[] arr) {
        int count = 0;
        for(int j = 0; j < arr.length; j++) {
            for(int i = 0 ; i < arr.length; i++) {
                if(arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                } else if(arr[i] < 50 && arr[i] % 2 == 1){
                    arr[i] = arr[i] * 2 + 1;
                } else {
                    count++;
                }
            }
            if(count == arr.length) {
                return j;
            } else {
                count = 0;
            }
        }
        
        return arr.length;
    }
}