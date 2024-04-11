# [18352] 특정 거리의 도시 찾기

## 분류
> 그래프 이론
>
> 그래프 탐색
> 
> 너비 우선 탐색
> 
> 데이크스트라
> 
> 최단 경로

## 코드
```java
import java.io.*;
import java.util.*;

public class BOJ18352 {
    private static int N, M, K, X;
    private static int[] distance;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph  = new ArrayList<>();
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        Arrays.fill(distance, (int)1e9);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        distance[X] = 0;
        dijkstra(X);


        List<Integer> res = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(distance[i] == K) res.add(i);
        }

        if(res.size() == 0) System.out.println(-1);
        else {
            for(int i = 0; i < res.size(); i++){
                System.out.println(res.get(i));
            }
        }
    }

    private static void dijkstra(int vertex) {
        // 방문하지 않은 인접노드(A)를 모두 방문하면서 (가중치가 다 같기 때문) 거리 따져주기
        // 즉, 노드에서 방문하지 않은 인접노드(A)를 모두 방문하고 A는 방문처리
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while(!queue.isEmpty()){
            int q = queue.poll(); // 현재 정점
            for(int i = 0; i < graph.get(q).size(); i++){ // 도착 정점
                int v = graph.get(q).get(i);
                if(!visited[v] && graph.get(q).get(i) != null){ // 방문X, graph[q][v] 간선존재할 때
                    if(distance[q] + 1 < distance[v]) distance[v] = distance[q] + 1;
                    queue.add(v);
                }
            }
            visited[q] = true;
        }

    }
}
```

## 문제풀이

인접 행렬과 인접 리스트의 명확한 차이는 다시 공부를 해봐야겠지만, 평소 BFS DFS 풀때처럼 이차원배열로 사용하니 메모리 초과로 틀렸다. 찾아보니 인접 리스트를 사용해야 한다고 해서, 일단 급하게 인접 리스트가 무엇인지 찾아보고, ArrayList<ArrayList<Integer>> graph;로 선언해줬다. 

인덱스로 이리저리 혼자 맞춰넣었더니 get함수로 뽑아오는 과정에서 혼동이 생겨 한참 걸리긴 했지만 일단 고치긴 했다.

일단 출발 노드를 큐에 넣으면서 시작한다. 그리고 while문으로 큐가 빌 때까지 반복한다. (BFS로 탐색)
그리고 간선이 있는 것만 탐색하기 시작하는데, 방문하지 않은 정점이거나 p->v 간선이 존재할 때 거리를 갱신해주어야 한다. 만약 q까지 간 거리 + 1이 v까지의 거리보다 작다면 최솟값이므로 v까지의 거리에 해당 값을 넣어주고, 그렇지 않다면 이미 최솟값이 들어있는 것이기 때문에 따로 갱신해줄 필요가 없다. 
그 후 queue에 다음에 탐색할, 현재의 도착 정점을 넣어준다. 
for 반복문이 끝나고 나서 시작 정점을 방문처리해주면 다시 정점으로 돌아갈 일이 없어진다. 

지금 풀이 적으면서 생각해보니 q -> v 간선이 존재할 때라는 조건문은 딱히 없어도 될 것 같다. 당연히 있을 때만 탐색하고 있기 때문에..!
