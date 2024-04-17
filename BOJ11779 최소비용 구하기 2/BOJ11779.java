import java.io.*;
import java.util.*;

public class BOJ11779 {
    static class Bus {
        int end;
        int cost;
        Bus(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    private static int n, m, start, end;
    private static int[] distance, city;
    private static ArrayList<ArrayList<Bus>> bus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distance = new int[n + 1];
        city = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        bus = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            bus.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            bus.get(a).add(new Bus(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        bw.write(distance[end] +"\n");

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        while(end != 0){
            stack.push(end);
            end = city[end];
            cnt++;
        }
        bw.write(cnt + "\n");
        while(!stack.isEmpty()){
            bw.write(stack.pop() + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dijkstra(int start) {
        PriorityQueue<Bus> pQueue = new PriorityQueue<>((q1, q2) -> q1.cost - q2.cost);
        pQueue.add(new Bus(start, 0));
        distance[start] = 0;
        boolean[] visited = new boolean[n + 1];

        while (!pQueue.isEmpty()) {
            int currentBus = pQueue.poll().end;

            if (!visited[currentBus]) {
                visited[currentBus] = true;

                for (Bus nextBus : bus.get(currentBus)) {
                    if (!visited[nextBus.end] && distance[nextBus.end] > distance[currentBus] + nextBus.cost) {
                        distance[nextBus.end] = distance[currentBus] + nextBus.cost;
                        city[nextBus.end] = currentBus;
                        pQueue.add(new Bus(nextBus.end, distance[nextBus.end]));
                    }
                }
            }
        }
    }

}
