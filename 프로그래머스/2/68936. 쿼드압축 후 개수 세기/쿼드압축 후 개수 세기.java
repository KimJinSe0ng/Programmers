/**
 * 상태 : (offsetX, offsetY, size) = 좌표 (offsetX, offsetY)에서 시작하여 가로 길이와 세로 길이가 size인 정사각형을 압축했을 때 남아 있는 0과 1의 개수
 * 종료 조건 : 상태가 나타내는 범위의 크기와 관계없이 범위 안 원소들이 모두 0이거나 1이면 하나의 수자로 압축
 * - 0의 개수가 zero, 1의 개수가 one 이라면
 * {0 : 1, 1 : 0} -> 모든 원소가 0
 * {0 : 0, 1 : 1} -> 모든 원소가 1
 * 점화식 : (offsetX, offsetY, size) = (offsetX, offsetY, size/2) + (offsetX + size/2, offsetY, size/2)
 * + (offsetX, offsetY + size/2, size/2) + (offsetX + size/2, offsetY + size/2, size/2)
 */
class Solution {
    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) { //모든 원소가 같은 값을 같는지 순회(검사)
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr) //모든 결과 합해서 반환
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }
        //다른 값을 가진 원소가 있다면 종료 조건에 해당하지 않고 점화식에 따라 반환값 구하기
        if (arr[offsetY][offsetX] == 1) { //해당 원소가 1인지 0인지에 따라 알맞은 개수를 갖는 Count 객체 반환
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }

    private static class Count {
        public final int zero;
        public final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) { //원소가 섞여있다면 재귀 메서드를 사용하여 점화식에 따라 부분 문제를 해결해야 함
            // 4개의 작은 정사각형 결과 합을 구해야 함
            return new Count(zero + other.zero, one + other.one);
        }
    }
}
