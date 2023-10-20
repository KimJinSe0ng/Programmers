import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt(); // 카드의 개수
    	int M = sc.nextInt(); // 딜러가 외친 숫자
    	int [] card = new int [N];
    	
    	for(int i=0; i<N; i++) {
    		card[i] = sc.nextInt();
    	}
    	int mini = 0;
    	// 3중 for문으로 카드 3개 고르기
    	for(int i=0; i<=N-3; i++) { // 첫 번째로 고르는 카드
    		for(int j=i+1; j<=N-2; j++) { // 두 번째로 고르는 카드
    			for(int k=j+1; k<N; k++) { // 세 번째로 고르는 카드
    				int hap = card[i]+card[j]+card[k];
    				// 세 카드의 합과 M이 같다면 hap을 출력하고 바로 종료
    				if(hap == M) {
    					System.out.println(hap);
    					return;
    				}
    				// hap이 이전 합보다 크고 M보다 작다면 (M에 더 가까운것임)
    				// mini에 hap 저장
    				if(mini < hap && hap < M) {
    					mini = hap;
    				}
    			}
    		}
    	}
    	System.out.println(mini);
    }
}