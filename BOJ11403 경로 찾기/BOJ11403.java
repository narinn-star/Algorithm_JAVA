import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11403 {
    private static int N;
    private static boolean[] visited;
    private static int[][] graph;
    private static int[][] result;

    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        result = new int[N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int x) {
        queue = new LinkedList<>();
        queue.add(x);

        while(!queue.isEmpty()){
            int q = queue.poll();
            for(int i = 1; i <= N; i++){
                if(graph[q][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    result[x][i] = 1;
                }
            }
        }
    }
}
