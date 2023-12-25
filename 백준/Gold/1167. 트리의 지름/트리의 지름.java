import java.util.*;

public class Main {
    //visited:방문 기록 저장 배열
    static boolean visited[];
    //distance:거리 저장 배열
    static int[] distance;
    static ArrayList<Edge>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //N:노드개수
        int N = sc.nextInt();
        //A: 그래프 데이터 저장 인접 리스트
        A = new ArrayList[N + 1];
        //A 인접 리스트의 각 ArrayList 초기화
        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }
        //A 인접 리스트에 그래프 데이터 저장
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1) {
                    break;
                }
                int V = sc.nextInt();
                A[S].add(new Edge(E, V));
            }
        }
        //visited 배열 초기화
        visited = new boolean[N + 1];
        //distance 배열 초기화
        distance = new int[N + 1];
        //BFS(임의의 점을 시작점으로) 실행
        BFS(1);
        //distance 배열에서 가장 큰 값을 지니고 있는 노드를 시작점으로 지정
        int Max = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[Max] < distance[i]) {
                Max = i;
            }
        }
        //visited 배열 초기화
        visited = new boolean[N + 1];
        //distance 배열 초기화
        distance = new int[N + 1];
        //BFS(새로운 시작점으로) 실행
        BFS(Max);
        //distance 배열에서 가장 큰 수를 정답으로 출력
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
    private static void BFS(int index) {
        //큐 자료구조에 시작 노드 삽입
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        //visited 배열에 현재 노드 방문 기록
        visited[index] = true;
        //while(큐가 비어 있을 때까지) {
        while (!queue.isEmpty()) {
            //큐에서 노드 데이터 가져오기
            int nowNode = queue.poll();
            //현재 노드의 연결 노드 중 반문하지 않은 노드로
            for (Edge i : A[nowNode]) {
                int e = i.e;
                int v = i.value;
                if (!visited[e]) {
                    //큐에 데이터 삽입하고 visited 배열에 방문 기록
                    visited[e] = true;
                    queue.add(e);
                    //그리고 현재 노드의 거리 + 에지의 가중치로 방문하지 않은 노드 거리 배열 업데이트
                    distance[e] = distance[nowNode] + v;
                }
            }
        }

    }
}

//에지 클래스 별도 구현
//e:목적지 노드, value:에지의 가중치
class Edge {
    int e;
    int value;
    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}
