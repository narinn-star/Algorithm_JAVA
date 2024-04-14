import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class BOJ1916 {
    static class Bus {
        int end;
        int cost;
        Bus(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }
    private static int[] res;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Bus>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Bus(end, cost));
        }

        visited = new boolean[N + 1];
        res = new int[N + 1];
        Arrays.fill(res, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int resStart = Integer.parseInt(st.nextToken());
        int resEnd = Integer.parseInt(st.nextToken());

        dijkstra(resStart);

        bw.write(res[resEnd] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dijkstra(int resStart){
        PriorityQueue<Bus> queue = new PriorityQueue<>((q1, q2) -> q1.cost - q2.cost);
        queue.add(new Bus(resStart, 0));
        res[resStart] = 0;

        while(!queue.isEmpty()){
            Bus now = queue.poll();
            int nowEnd = now.end;

            if(!visited[nowEnd]){
                visited[nowEnd] = true;
                for(Bus bus : list.get(nowEnd)){
                    if(!visited[bus.end] && res[bus.end] > res[nowEnd] + bus.cost){
                        res[bus.end] = res[nowEnd] + bus.cost;
                        queue.add(new Bus(bus.end, res[bus.end]));
                    }
                }
            }
        }
    }
}
