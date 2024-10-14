class Solution {
    public int[][] solution(int[][] arr) {
        int rowCount = arr.length;       // 행의 수
        int colCount = arr[0].length;    // 열의 수
        
        // 행의 수가 더 많은 경우
        if (rowCount > colCount) {
            // 각 행의 끝에 0을 추가해서 열의 수를 맞춤
            for (int i = 0; i < rowCount; i++) {
                int[] newRow = new int[rowCount]; // 새로운 행 크기를 rowCount로 설정
                // 기존 배열 복사
                for (int j = 0; j < colCount; j++) {
                    newRow[j] = arr[i][j];
                }
                arr[i] = newRow;
            }
        }
        // 열의 수가 더 많은 경우
        else if (colCount > rowCount) {
            int[][] newArr = new int[colCount][colCount]; // 새로운 2차원 배열 크기를 colCount로 설정
            // 기존 배열 복사
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    newArr[i][j] = arr[i][j];
                }
            }
            arr = newArr; // 새로운 배열로 덮어씀
        }
        
        // 결과 배열 반환
        return arr;
    }
}