class Solution {
    public int[] solution(int[] arr, int k) {
        boolean isOddNumber = (k % 2 == 1) ? true : false;
        for(int i = 0; i < arr.length; i++) {
            if(isOddNumber) {
                arr[i] *= k;
            } else {
                arr[i] += k;
            }
        }
        return arr;
    }
}