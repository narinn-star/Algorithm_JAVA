# [24479] 알고리즘 수업 - 깊이 우선 탐색 1

## 분류
> 그래프 이론
>
> 그래프 탐색
>
> 정렬
>
> 너비 우선 탐색

## 코드
```java
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

```

## 문제풀이
알고리즙 수업 이라는 똑같은 타이틀이라 그런지 dfs랑 문제는 똑같은데 bfs로 풀어내는 것이다.

일단 bfs도 너무 오랜만이라 queue로 하는 건 기억했는데, 왜 바보같이 재귀로 풀어서 자꾸 틀렸는지 모를 일.. 디버깅 하다보니 이게 탈출 문이 필요하고.. 그러다 보니 while이 생각나서 또 갈아 엎고 갈아 엎고 계속 반복 해서 고쳤다.
예제 문제도 맞았고, 질문 게시판에 있는 반례도 맞았는데 왜 틀린것인지 계속 확인 해보니..!
처음에 for문에서 간선 표시할 때 반복문 횟수가 잘못 되었던 것 .. ㅠㅠㅠ
너무 어이없는 실수로 2시간이나 까먹어버렸다..

