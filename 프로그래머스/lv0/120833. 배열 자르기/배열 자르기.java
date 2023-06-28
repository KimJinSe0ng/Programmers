class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] newNumbers = new int[num2-num1+1];
        int j = 0;
        for (int i = num1; i <= num2; i++) {
            newNumbers[j] = numbers[i];
            j += 1;
        }
        return newNumbers;
    }
}