import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            //뒤에서부터 큰값이 나오면 리셋하기.맨뒤에 값이 무조건 큰값이라고 가정하기
            long max = Long.MIN_VALUE;
            int num = 0;
            long cost = 0; //구매가
            long result = 0; //최종
            for (int i = A.length - 1; i >= 0; i--) {
                // 더 큰 최댓값을 찾았다면? 호다닥 사자 ! 비용계산하기 : 사야할 애들의 갯수  * 판매가  - 구매가
                if (A[i] > max) {
                    result += (max * num - cost);
                    max = A[i];
                    //초기화
                    cost = 0;
                    num = 0;
                } else {    //max 보다 작으면 사자
                    cost += A[i];
                    num++;
                }
            }

            //마지막에 한번 더 해주기
            result += (max * num - cost);
            System.out.println("#" + tc + " " + result);
        }
    }
}