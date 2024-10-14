class Solution {
    public int[][] solution(int n) {
        int[][] result = new int[n][n];  // n × n 크기의 2차원 배열 생성
        int num = 1;                     // 배열에 채울 숫자 (1부터 시작)
        int left = 0, right = n - 1;     // 좌우 경계
        int top = 0, bottom = n - 1;     // 상하 경계

        while (left <= right && top <= bottom) {
            // 1. 왼쪽에서 오른쪽으로 채움
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;  // 상단 경계를 줄임

            // 2. 위에서 아래로 채움
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;  // 우측 경계를 줄임

            // 3. 오른쪽에서 왼쪽으로 채움 (bottom이 top보다 크거나 같을 때만)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = num++;
                }
                bottom--;  // 하단 경계를 줄임
            }

            // 4. 아래에서 위로 채움 (right가 left보다 크거나 같을 때만)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = num++;
                }
                left++;  // 좌측 경계를 줄임
            }
        }

        return result;  // 결과 배열 반환
    }
}