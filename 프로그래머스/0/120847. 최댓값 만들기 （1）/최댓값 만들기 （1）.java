import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int first = numbers.length - 1;
        int second = numbers.length - 2;
        return numbers[first] * numbers[second];
    }
}