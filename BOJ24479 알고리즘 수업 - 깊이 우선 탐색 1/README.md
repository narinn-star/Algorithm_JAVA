# [24479] 알고리즘 수업 - 깊이 우선 탐색 1

## 분류
> 그래프 이론
>
> 그래프 탐색
>
> 정렬
>
> 깊이 우선 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24479 {
    private static int[] visited;
    private static int N, M, R, cnt = 1;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];

        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<Integer>());
            //System.out.println(graph);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            //양방향 간선 체크
            graph.get(start).add(to);
            graph.get(to).add(start);
            //System.out.println(graph);
        }

        for(int i = 0; i < graph.size(); i++){
            Collections.sort(graph.get(i)); // 오름차순 정렬
        }

        dfs(R);

        for(int i = 1; i < visited.length; i++){
            System.out.println(visited[i]);
        }
    }
    private static void dfs(int vertex) {
       visited[vertex] = cnt;

       for(int i = 0; i<graph.get(vertex).size(); i++) {
           int v = graph.get(vertex).get(i);
           if(visited[v] == 0) {
               cnt++;
               dfs(v);
           }
       }
    }
}
```

## 문제풀이
문제에서 요구하는 것은 각 정점의 방문 순서이다.
'방문을 하는 순서'가 아니라 1-5-4-2-3 이라면 1-4-5-3-2 이렇게 출력 해야한다.

양방향 간선이기 때문에 입력이 1 2 라면 배열 2 1도 추가해주었다.
오름차순 정렬은 Collections.sort()를 사용했음!

사실 이 문제를 풀려고 했을 때 무슨 말인지 정말 하나도 모르곘어서 실버3(바이러스) 먼저 풀었더랬다. 풀기 전에 이 문제에 접근을 어떻게 하는 건지는 보고 넘어가자. 해서 구글링을 했는데, ArrayList<T>에 ArrayList를 넣어서 사용하고 있는 것..! (사실 이때도 뭔 말인가 했음) 바이러스 문제 호다닥 풀고 나서 바로 ArrayList 사용해서 풀었다.

dfs 함수에서 for문 안에 v 를 가져와 visited 처리 해주고, cnt 증가시켜주고 재귀 호출까지는 괜찮았는데, 제출은 총 4번만에 성공했다.

74%까지 올라가다 멈췄고, 이곳 저곳 고치면서 원래 있던 answer배열 (출력 담을 배열. 위의 코드에는 answer과 visited를 합침. 이전에는 visited boolean 형으로 true/false만 판단해줬었다.)을 없애기도 하고.. 
아주 놀랍게도 첫 함수 호출을 dfs(1)로 하고 있었다.😭
우여곡절 끝에 성공..!
