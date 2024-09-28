class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int s = query[0];  // 시작 인덱스
            int e = query[1];  // 종료 인덱스
            int k = query[2];  // k의 배수 조건
            
            // s부터 e까지 확인하면서 k의 배수인 인덱스에 대해 arr[i]에 1을 더함
            for (int i = s; i <= e; i++) {
                if (i % k == 0) {
                    arr[i] += 1;
                }
            }
        }
        
        return arr;
    }
}