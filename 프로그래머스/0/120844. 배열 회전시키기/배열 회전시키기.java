class Solution {
    public int[] solution(int[] numbers, String direction) {
        int length = numbers.length;
        int[] result = new int[length];
        
        if (direction.equals("right")) {
            result[0] = numbers[length - 1]; 
            for (int i = 1; i < length; i++) {
                result[i] = numbers[i - 1]; 
            }
        } else if (direction.equals("left")) {
            result[length - 1] = numbers[0]; 
            for (int i = 0; i < length - 1; i++) {
                result[i] = numbers[i + 1];
            }
        }

        return result;
    }
}