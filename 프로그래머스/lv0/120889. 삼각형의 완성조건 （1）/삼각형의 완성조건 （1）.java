import java.util.*;
class Solution {
    public int solution(int[] sides) {
        // int max = Arrays.stream(sides).max().getAsInt();
        Arrays.sort(sides);
        if (sides[2] < (sides[0] + sides[1])) return 1;
        else return 2;
    }
}