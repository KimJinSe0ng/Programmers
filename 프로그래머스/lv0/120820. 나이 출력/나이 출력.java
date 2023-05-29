class Solution {
    public int solution(int age) {
        if (age > 0 && age < 121) {
            age = 2022 - age + 1;
            return age;
        }
        return -1;
    }
}