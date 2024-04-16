import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {
    static class Village {
        int end;
        int weight;

        Village(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    private static int N, M, X;
    private static int[] dist, reverse_dist;
    private static ArrayList<ArrayList<Village>> village;
    private static ArrayList<ArrayList<Village>> reverse_village;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        village = new ArrayList<>();
        reverse_village = new ArrayList<>();

        dist = new int[N + 1];
        reverse_dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            village.add(new ArrayList<>());
            reverse_village.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(reverse_dist, Integer.MAX_VALUE);

        dist[X] = 0;
        reverse_dist[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            village.get(start).add(new Village(end, weight));
            reverse_village.get(end).add(new Village(start, weight));
        }

        dijkstra(village, dist);
        dijkstra(reverse_village, reverse_dist);

        int result = 0;
        for(int i = 1; i <= N; i++ ){
            result = Math.max(result, dist[i] + reverse_dist[i]);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(ArrayList<ArrayList<Village>> list, int[] distance) {
        PriorityQueue<Village> pQueue = new PriorityQueue<>((q1, q2) -> q1.weight - q2.weight);
        boolean[] visited = new boolean[N + 1];
        pQueue.add(new Village(X, 0));

        while(!pQueue.isEmpty()){
            int currentVillage = pQueue.poll().end;

            if(!visited[currentVillage]){
                visited[currentVillage] = true;

                for(Village village1 : list.get(currentVillage)){
                    if(!visited[village1.end] && distance[village1.end] > distance[currentVillage] + village1.weight) {
                        distance[village1.end] = distance[currentVillage] + village1.weight;
                        pQueue.add(new Village(village1.end, distance[village1.end]));
                    }
                }
            }
        }
    }
}
