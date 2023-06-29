class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        int drink = money / 5500;
        money -= drink * 5500;
        answer[0] = drink;
        answer[1] = money;
        return answer;
    }
}