class Solution {
    private static class Count { //1.상태 : 0과 1의 개수를 한 번에 담을 수 있는 클래스
        public final int zero;
        public final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) { //원소가 섞여 있다면 재귀 메서드를 사용해 점화식에 따라 부분 문제를 해결해야 한다.
            //4개의 작은 정사각형 결과 합을 구해야 하므로, 간단히 두 Count 객체를 합하는 메서드 정의
            return new Count(zero + other.zero, one + other.one);
        }
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) { //2.재귀 메서드
        //3.종료 조건
        //정사각형 영역 안의 모든 원소가 같은 값을 가질 때 종료
        //모든 원소가 같은 값을 같는지 검사
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        //모든 원소가 같은 경우
        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }

    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }
}