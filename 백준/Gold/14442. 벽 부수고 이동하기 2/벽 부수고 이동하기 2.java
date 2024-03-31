import java.io.*;
import java.util.*;

class Node{
	int y;
	int x;
	int drill;
	int count;
	Node(int y,int x,int drill,int count){
		this.y=y;
		this.x=x;
		this.drill=drill;
		this.count=count;
	}
}
public class Main {
	static char map[][];
	static int xx[]= {-1,1,0,0};
	static int yy[]= {0,0,-1,1};
	static int cnt=-1;
	static int max=0;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		max=Integer.parseInt(st.nextToken());
		map=new char[n][m];

		for(int i=0;i<n;i++) {
			String line=br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=line.charAt(j);
			}
		}

		bfs();

		System.out.println(cnt);

	}
	public static void bfs() {
		boolean visited[][][]=new boolean[map.length][map[0].length][max+1];
		for(int i=0;i<max;i++) {
			visited[0][0][i]=true;
		}
		Queue<Node> queue=new LinkedList<>();
		queue.add(new Node(0,0,0,1));
		while(!queue.isEmpty()) {
			Node temp=queue.poll();
			int prevY=temp.y;
			int prevX=temp.x;
			int drill=temp.drill;
			int count=temp.count;
			if(prevY==map.length-1&&prevX==map[0].length-1) {
				cnt=count;
				return;
			}
			for(int i=0;i<4;i++) {
				int nextY=prevY+yy[i];
				int nextX=prevX+xx[i];
				if(nextY<0||nextX<0||nextY>=map.length||nextX>=map[0].length) continue;

				if(map[nextY][nextX]=='0') { 
					if(visited[nextY][nextX][drill]==false) {
						queue.add(new Node(nextY,nextX,drill,count+1)); 
						visited[nextY][nextX][drill]=true;
					}
				}
				else { 
					if(drill+1<=max) { 
						if(visited[nextY][nextX][drill+1]==false) {
							queue.add(new Node(nextY,nextX,drill+1,count+1));
							visited[nextY][nextX][drill+1]=true;
						}
					}
				}



			}
		}
	}
}