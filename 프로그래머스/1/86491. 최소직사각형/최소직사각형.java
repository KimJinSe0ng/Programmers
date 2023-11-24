class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 0; i < sizes.length; i++) { //긴 부분을 가로로 재배치
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            if (maxWidth < sizes[i][0]) {
                maxWidth = sizes[i][0];
            }
            if (maxHeight < sizes[i][1]) {
                maxHeight = sizes[i][1];
            }
        }

        return maxWidth * maxHeight;
    }
}