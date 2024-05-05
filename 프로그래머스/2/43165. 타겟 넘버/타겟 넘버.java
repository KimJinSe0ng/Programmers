class Solution {
    public int solution(int[] numbers, int target) {
    return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int acc) {
    if (index == numbers.length) {
        return acc == target ? 1 : 0;
    }

    int count = 0;
    count += dfs(numbers, target, index + 1, acc - numbers[index]);
    count += dfs(numbers, target, index + 1, acc + numbers[index]);
    
    return count;
    }
}

