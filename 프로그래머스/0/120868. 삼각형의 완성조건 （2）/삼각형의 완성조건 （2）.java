class Solution {
    public int solution(int[] sides) {
        int total_side = 0;
        int max_side = Math.max(sides[0], sides[1]);
        int min_side = Math.min(sides[0], sides[1]);
        
        total_side += (max_side + min_side) - max_side; //가장 큰 변이 max_side인 경우
        total_side += (max_side + min_side) - (max_side + 1); //임의의 변이 가장 큰 변인 경우
        return total_side;
    }
}