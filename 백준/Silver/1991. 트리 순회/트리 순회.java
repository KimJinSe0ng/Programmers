import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int tree[][];
	
	// 전위 순회
	static void preorder_traverse(int node) {
		if (node == -19) return; // '.'인 경우 종료
		System.out.print((char)(node+65)); // 노드 출력
		preorder_traverse(tree[node][0]); // 왼쪽 자식 순회
		preorder_traverse(tree[node][1]); // 오른쪽 자식 순회
	}
	
	// 중위 순회
	static void inorder_traverse(int node) {
		if (node == -19) return; // '.'인 경우 종료
		inorder_traverse(tree[node][0]); // 왼쪽 자식 순회
		System.out.print((char)(node+65)); // 노드 출력
		inorder_traverse(tree[node][1]); // 오른쪽 자식 순회
	}
	
	// 후위 순회
	static void postorder_traverse(int node) {
		if (node == -19) return; // '.'인 경우 종료
		postorder_traverse(tree[node][0]); // 왼쪽 자식 순회
		postorder_traverse(tree[node][1]); // 오른쪽 자식 순회
		System.out.print((char)(node+65)); // 노드 출력
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 노드 개수 입력
		N = Integer.parseInt(st.nextToken());
		tree = new int [26][2];
		
		// 노드 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			int idx = (int)st.nextToken().charAt(0) - 65;
			tree[idx][0] = (int)st.nextToken().charAt(0) - 65;
			tree[idx][1] = (int)st.nextToken().charAt(0) - 65;
		}
		
		preorder_traverse(0);
		System.out.println();
		inorder_traverse(0);
		System.out.println();
		postorder_traverse(0);
	}
}