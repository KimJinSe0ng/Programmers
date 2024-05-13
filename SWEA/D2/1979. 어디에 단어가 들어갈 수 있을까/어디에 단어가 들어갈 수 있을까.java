/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // 테스트 캐이스 입력
		for (int t = 1; t <= T; t++) {
        int N = sc.nextInt(); // 단어퍼즐 사이즈 n
        int K = sc.nextInt(); // 단어 사이즈 k

        int ans = 0; // k단어가 들어갈 수 있는 자리
        int[] cntCol = new int[N]; // 열 자리 확인 배열
        for (int i = 0; i < N; i++) {
            int cntRow = 0; // 행 자리 확인 변수
            for (int j = 0; j < N; j++) {
                // 자리가 있을 때
                if (sc.nextInt() == 1) {
                    // 행 확인
                    if (++cntRow == K) ans++; // 자리가 딱 K자리 수 이면 정답++
                    else if (cntRow == K+1) ans--; // K자리보다 커지면 아까 더했던 정답 다시 --

                    // 열 확인
                    if (++cntCol[j] == K) ans++; // 자리가 딱 K자리 수 이면 정답++
                    else if(cntCol[j] == K+1) ans--; // K자리보다 커지면 아까 더했던 정답 다시 --
                }
                // 0이 들어오면 확인변수 다시 초기화
                else {
                    cntRow = 0;
                    cntCol[j] = 0;
                }
            }
        } // 퍼즐 입력 for

        System.out.printf("#%d %d\n", t, ans);
    } // testcase for
    }
}