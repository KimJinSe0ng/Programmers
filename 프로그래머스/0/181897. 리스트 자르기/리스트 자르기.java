import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        if (n == 1) {
            // 0번 인덱스부터 b번 인덱스까지 슬라이싱
            return Arrays.copyOfRange(num_list, 0, b + 1);
        } else if (n == 2) {
            // a번 인덱스부터 마지막 인덱스까지 슬라이싱
            return Arrays.copyOfRange(num_list, a, num_list.length);
        } else if (n == 3) {
            // a번 인덱스부터 b번 인덱스까지 슬라이싱
            return Arrays.copyOfRange(num_list, a, b + 1);
        } else if (n == 4) {
            // a번 인덱스부터 b번 인덱스까지 c 간격으로 슬라이싱
            int size = (b - a) / c + 1;  // 결과 리스트의 크기를 계산
            int[] result = new int[size];
            int idx = 0;

            for (int i = a; i <= b; i += c) {
                result[idx++] = num_list[i];
            }
            return result;
        }
        return new int[0];
    }
}