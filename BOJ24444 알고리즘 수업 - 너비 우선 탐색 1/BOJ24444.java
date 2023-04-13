import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24444 {
    private static int N, M, R, cnt = 1;
    private static boolean[] visited;
    private static int[] answer;

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(start).add(to);
            graph.get(to).add(start);
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }


        bfs(R);

        for (int i = 1; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        answer[vertex] = cnt;
        queue.add(vertex);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < graph.get(poll).size(); i++) {
                int v = graph.get(poll).get(i);
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    answer[v] = ++cnt;
                }
            }
        }
    }
}
