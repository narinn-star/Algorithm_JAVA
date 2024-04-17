# [11779] 최소비용 구하기 2

## 분류
> 그래프 이론
> 
> 데이크스트라
> 
> 최단 경로

## 코드
```java
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
```

## 문제풀이

다익스트라는 늘 똑같은 방식이고, 역추적이 이 문제의 포인트다. 

어떻게 해야할 지 진짜 감도 안잡혀서 다른 분의 코드를 참고했다.. 
최소비용을 갱신해줄 때 이전 방문 도시를 city[nextBus.end]에 저장해주는 방식이다. 
스택에 end부터 하나씩 넣고, (도착지점이랑 출발지점 잘 계산해서 넣어야함) 꺼내서 출력하면 된다.
