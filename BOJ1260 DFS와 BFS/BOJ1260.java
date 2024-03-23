import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    private static int N, M, V;
    private static boolean[][] graph;
    private static boolean[] check;
    private static boolean[] visited;
    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        check = new boolean[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }
        System.out.print(V + " ");
        check[V] = true;
        dfs(V);

        System.out.println();
        bfs(V);
    }

    private static void dfs(int vertex) {
        for (int i = 1; i <= N; i++) {
            if (graph[vertex][i] == true && !check[i]) {
                check[i] = true;
                System.out.print(i + " ");
                dfs(i);
            }
        }
    }

    private static void bfs(int vertex) {
        queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int q = queue.poll();
            System.out.print(q + " ");

            for (int i = 1; i <= N; i++) {
                if (graph[q][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
