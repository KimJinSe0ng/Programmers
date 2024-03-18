import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer1, answer2, answer3;
	static int cnt1, cnt2, cnt3;
	static int n;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		func(0,0,n);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
		
	}
	public static void func(int r, int c, int size) { 
		if(size==1) { 
			if(arr[r][c]==-1) answer1++;
			else if(arr[r][c]==0) answer2++;
			else answer3++;
			
			return;
		}
		
		cnt1=0; cnt2=0; cnt3=0;
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[i][j]==-1) cnt1++;
				else if(arr[i][j]==0) cnt2++;
				else cnt3++;
			}
		}
		
		int multi=size*size;
		if(cnt1==multi || cnt2==multi || cnt3==multi) { 
			if(cnt1==multi) answer1++;
			else if(cnt2==multi) answer2++;
			else answer3++; 
		}else {
			int newSize=size/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					func(r+i*newSize, c+j*newSize, newSize); 
				}
			}
			
		}
		
	}
}