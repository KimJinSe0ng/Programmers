import java.util.Scanner;

public class Main {
	static int dp[][];
	static int novel[];
	static int sum[];
	static int k;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t > 0) {
			k = scanner.nextInt();
			dp = new int[k + 1][k + 1];
			novel = new int[k + 1];
			sum = new int[k + 1];
			for (int i = 1; i <= k; i++) {
				novel[i] = scanner.nextInt();
				sum[i] = sum[i - 1] + novel[i]; 
			}
			algorithm1();
			t--;
		}
	}
	public static void algorithm1() {
		for (int n = 1; n <= k; n++) { 
			for (int i = 1; i + n <= k; i++) {
				int j = i + n;
				dp[i][j] = 214748364; 
				for (int x = i; x < j; x++) {
					dp[i][j] = Math.min(dp[i][j],
							dp[i][x] + dp[x + 1][j] + sum[j] - sum[i - 1]);
				}
			}
		}
		System.out.println(dp[1][k]);
	}
}