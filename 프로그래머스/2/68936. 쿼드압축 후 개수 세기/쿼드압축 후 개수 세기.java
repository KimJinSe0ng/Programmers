class Solution {
    //하나의 재귀에서는 해당 상태가 나타내는 정사각형을 압축했을 때 남아 있는 0과 1의 개수를 구해야 하고, 한 번에 담을 수 있는 클래스
    private static class Count {
        public final int zero;
        public final int one;
        
        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        public Count add(Count other) {
            //작은 정사각형 결과 합을 구해야 함
            return new Count(zero + other.zero, one + other.one);
        }
    }
    
    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }
    
    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        //종료 조건
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    //원소가 섞여 있다면 재귀 메서드를 이용해 점화식에 따라 부분 문제 해결
                    return count(offsetX, offsetY, h, arr)
                        .add(count(offsetX + h, offsetY, h, arr))
                        .add(count(offsetX, offsetY + h, h, arr))
                        .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }
        
        //이중 반복문은 모든 원소가 같은 값을 갖는지 검사. 이종 반복문이 종료되면 모든 원소가 같은 값을 갖고 있다.
        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }
}