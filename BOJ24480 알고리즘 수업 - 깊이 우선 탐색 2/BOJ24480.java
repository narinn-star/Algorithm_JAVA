import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24480 {
    private static int N, M, R, cnt = 1;
    private static int[] visited;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(start).add(to);
            graph.get(to).add(start);
        }

        for(int i = 0 ; i < graph.size(); i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(R);

        for(int i = 1; i < visited.length; i++){
            System.out.println(visited[i]);
        }
    }
    private static void dfs(int vertex){
        visited[vertex] = cnt;
        for(int i = 0; i < graph.get(vertex).size(); i++){
            int v = graph.get(vertex).get(i);
            if(visited[v] == 0){
                cnt++;
                dfs(v);
            }
        }
    }
}
