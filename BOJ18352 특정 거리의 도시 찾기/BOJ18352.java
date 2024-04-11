import java.io.*;
import java.util.*;

public class BOJ18352 {
    private static int N, M, K, X;
    private static int[] distance;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph  = new ArrayList<>();
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        Arrays.fill(distance, (int)1e9);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        distance[X] = 0;
        dijkstra(X);


        List<Integer> res = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(distance[i] == K) res.add(i);
        }

        if(res.size() == 0) System.out.println(-1);
        else {
            for(int i = 0; i < res.size(); i++){
                System.out.println(res.get(i));
            }
        }
    }

    private static void dijkstra(int vertex) {
        // 방문하지 않은 인접노드(A)를 모두 방문하면서 (가중치가 다 같기 때문) 거리 따져주기
        // 즉, 노드에서 방문하지 않은 인접노드(A)를 모두 방문하고 A는 방문처리
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while(!queue.isEmpty()){
            int q = queue.poll(); // 현재 정점
            for(int i = 0; i < graph.get(q).size(); i++){ // 도착 정점
                int v = graph.get(q).get(i);
                if(!visited[v] && graph.get(q).get(i) != null){ // 방문X, graph[q][i] 간선존재할 때
                    if(distance[q] + 1 < distance[v]) distance[v] = distance[q] + 1;
                    queue.add(v);
                }
            }
            visited[q] = true;
        }

    }
}
