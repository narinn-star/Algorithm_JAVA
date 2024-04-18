# [5972] 택배 배송

## 분류
> 그래프 이론
> 
> 데이크스트라
> 
> 최단 경로

## 코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ5972 {
    static class Road {
        int end;
        int cow;

        Road(int end, int cow) {
            this.end = end;
            this.cow = cow;
        }
    }

    private static int N, M;
    private static int[] dist;
    private static ArrayList<ArrayList<Road>> road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        road = new ArrayList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            road.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cow = Integer.parseInt(st.nextToken());

            road.get(start).add(new Road(end, cow));
            road.get(end).add(new Road(start, cow));
        }

        dijkstra();

        bw.write(dist[N] +"\n");
        bw.flush();
        bw.close();
        br.close();

    }
    private static void dijkstra(){
        PriorityQueue<Road> pQueue = new PriorityQueue<>((p1, p2) -> p1.cow - p2.cow);
        boolean[] visited = new boolean[N+1];
        dist[1] = 0;
        pQueue.add(new Road(1, 0));

        while(!pQueue.isEmpty()){
            int curRoad = pQueue.poll().end;

            if(!visited[curRoad]){
                visited[curRoad] = true;

                for (Road nextRoad : road.get(curRoad)) {
                    if (!visited[nextRoad.end] && dist[nextRoad.end] > dist[curRoad] + nextRoad.cow) {
                        dist[nextRoad.end] = dist[curRoad] + nextRoad.cow;
                        pQueue.add(new Road(nextRoad.end, dist[nextRoad.end]));
                    }
                }
            }
        }
    }
}

```

## 문제풀이

1 -> N으로 가는 최단경로를 구하는 것. 이제껏 풀어왔던 다익스트라와 다를 점이 전---혀 없다...
쓸 풀이가 없어요... 


오늘 마지막 다익스트라인데, 완벽하게 이해한 것 같으면서도, 너무 외우듯 풀어버려서 나중에 꼭 두번 세번 더 풀어봐야할 것 같다
