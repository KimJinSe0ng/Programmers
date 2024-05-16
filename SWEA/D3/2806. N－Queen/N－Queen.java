import java.io.*;
import java.util.*;

class Solution
{
	static int n;
    static int count = 0;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        	board = new int[n];
            count = 0;
        	nqueen(0);
        	System.out.printf("#%d %d\n", i, count);
        }
    }

    private static void nqueen(int depth) {
        //cdx가 마지막 행까지 수행하고 여기까지 오면, 찾기 완료
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[depth] = i; //cdx번째 행, i번째 열에 queen을 놓아본다.
            //이후 그 행에 둔 것에 대한 유망성을 판단한다.
            if (promising(depth)) { //그 자리에 두어도 괜찮았다면,
//                System.out.println("cdx = " + depth + " i = " + i);
                nqueen(depth + 1); //그 다음 행에 대해 퀸을 놓는 것을 해 본다.
            }
        }
    }

    //유망한지 판단하는 함수
    private static boolean promising(int col) {
        //같은 열이면 안되고, 대각선상에 있어서도 안 된다.
        for (int i = 0; i < col; i++) {
            //행 번호 차이 = 열 번호 차이 -> 같은 대각선 상에 있음
            if (board[col] == board[i] || Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }
        return true;
    }
}