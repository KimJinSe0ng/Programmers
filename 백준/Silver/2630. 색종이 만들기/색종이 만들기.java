import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int white = 0, blue = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n]; 
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		confetti(0, 0, n);
		System.out.println(white + "\n" + blue);
		
	}
	static void confetti(int x, int y, int size) {
		int sum = 0;
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				sum += arr[i][j];
			}
		}
		
		if (sum == 0) white++;
		
		else if (sum == size * size) blue++;
		
		else {
			int half = size / 2;
			confetti(x, y, half); 
			confetti(x, y + half, half); 
			confetti(x + half, y, half);
			confetti(x + half, y + half, half); 
		}
		
		
	}
	
}