import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
    static class Graph {
        int v;
        int w;

        Graph(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static int V, E, K;
    private static int[] path;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Graph>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Graph(v, w));
        }

        path = new int[V + 1];
        Arrays.fill(path, 100_000_000);
        dijkstra(K);

        for(int i = 1; i <= V; i++){
            if(path[i] == 100_000_000) bw.write("INF\n");
            else bw.write(path[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Graph> pQueue = new PriorityQueue<>((q1, q2) -> q1.w - q2.w);
        visited = new boolean[V + 1];
        pQueue.add(new Graph(start, 0));
        path[start] = 0;

        while(!pQueue.isEmpty()){
            Graph now = pQueue.poll();
            int nowStart = now.v;

            if(!visited[nowStart]){
                visited[nowStart] = true;
                for(Graph g : graph.get(nowStart)){
                    if(path[g.v] > path[nowStart] + g.w){
                        path[g.v] = path[nowStart] + g.w;
                        pQueue.add(new Graph(g.v, path[g.v]));
                    }
                }
            }
        }

    }
}
