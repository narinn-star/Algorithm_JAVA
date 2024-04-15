# [1753] 최단경로

## 분류
> 그래프 이론
>
> 데이크스트라
>
> 최단 경로

## 코드
```java
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
```

## 문제풀이

어제 풀었던 [최소 비용 구하기](https://github.com/narinn-star/Algorithm_JAVA/tree/master/BOJ1916%20%EC%B5%9C%EC%86%8C%20%EB%B9%84%EC%9A%A9%20%EA%B5%AC%ED%95%98%EA%B8%B0) 문제랑 거의 동일하다. 풀이도 거의 동일. 모든 도착점을 다 구하는 것이지만 이미 담겨 있는 값을 출력하기만 하면 되기때문에, 크게 어렵지 않았다. 

조금 반성할 점은 변수를 너무 성의없이 작성했다는 점.. v랑 w가 너무 헷갈려서 답이 자꾸 오류가 났다.. 가능하면 단어로 작성하는 게 좋을 것 같음..

다익스트라도 템플릿이 거의 정해진듯 한 유형인데, DP나 BFS, DFS도 정해진 템플릿이지만 완전히 내것으로 만들기 까지는 2-3번 반복해서 풀어야했다. 아마 다음에 풀 때 또 똑같은 고민을 하고 있겠지만.. 더 해야겠다는 생각이 들었다 그 말..
