# [1260] DFS와 BFS

## 분류
> 그래프 이론
>
> 그래프 탐색
> 
> 너비 우선 탐색
>
> 깊이 우선 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    private static int N, M, V;
    private static boolean[][] graph;
    private static boolean[] check;
    private static boolean[] visited;
    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        check = new boolean[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }
        System.out.print(V + " ");
        check[V] = true;
        dfs(V);

        System.out.println();
        bfs(V);
    }

    private static void dfs(int vertex) {
        for (int i = 1; i <= N; i++) {
            if (graph[vertex][i] == true && !check[i]) {
                check[i] = true;
                System.out.print(i + " ");
                dfs(i);
            }
        }
    }

    private static void bfs(int vertex) {
        queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int q = queue.poll();
            System.out.print(q + " ");

            for (int i = 1; i <= N; i++) {
                if (graph[q][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

```

## 문제풀이

둘 다 템플릿이 정해져있어서 큰 부담 없이 풀어냈다.
(몇 달 전만해도 힘들었는데 뿌듯..)

DFS
우선 방문 체크를 할 check 배열을 만들어주고, dfs 함수를 호출하기 전에 방문 여부를 체크해줬다.

dfs 함수 내에서는 간선이 있는지와 방문 여부를 체크해서 그 다음 정점으로 이동하면 된다.
정점으로 이동하면 출력을 하고 해당 정점에서 또 다른 정점으로 이동하기 위해 dfs(i)를 호출한다.

BFS
큐를 이용해서 정점을 넣어주고 빼는 것을 반복한다.
방문 체크를 할 visited 배열을 만들어주고, bfs 함수를 호출한다.

bfs 함수 내에서는 해당 정점 방문 여부를 체크하고 큐에 넣는다.
큐가 빌 때까지 반복문을 수행하는데, 체크해야할 것은 간선이 있는지와 방문여부로 dfs랑 동일하다.
그 다음에는 큐에 해당 정점을 넣어주면 반복문이 계속되면서 너비우선탐색이 완료된다.

