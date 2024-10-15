class Solution {
    public int solution(int hp) {
        //장군: 5, 병정: 3, 일: 1
        int ant = 0;
        ant += hp / 5;
        hp = hp % 5;
        ant += hp / 3;
        hp = hp % 3;
        ant += hp / 1;
        hp = hp % 1;
        return ant;
    }
}