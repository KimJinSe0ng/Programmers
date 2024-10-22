class Solution {
    public int solution(int[][] lines) {
        int[] lineOverlap = new int[201]; 
        
        for (int[] line : lines) {
            int start = line[0] + 100; // -100부터 100까지의 범위를 0부터 200까지로 변환
            int end = line[1] + 100;
            for (int i = start; i < end; i++) {
                lineOverlap[i]++;
            }
        }

        int overlapLength = 0;
        for (int count : lineOverlap) {
            if (count > 1) {
                overlapLength++;
            }
        }

        return overlapLength;
    }
}