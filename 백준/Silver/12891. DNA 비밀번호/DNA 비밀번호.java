import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //12891
    static int checkArr[]; //비밀번호 체크 배열
    static int myArr[]; //현재 상태 배열
    static int checkSecret; //몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        char[] DNA = new char[S];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        DNA = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) { //초기 P 부분 문자열 처리 부분
            Add(DNA[i]);
        }

        if (checkSecret == 4) {
            result++;
        }
        //슬라이딩 윈도우 처리 부분
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(DNA[i]);
            Remove(DNA[j]);
            if (checkSecret == 4) {
                result++; //4자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호
            }
        }
        System.out.println(result);
        br.close();
    }

    private static void Add(char c) { //새로 들어온 문자를 처리하는 함수
        switch (c) {
            case 'A' :
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }

    private static void Remove(char c) { //제거되는 문자를 처리하는 함수
        switch (c) {
            case 'A' :
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C' :
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G' :
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T' :
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
