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

public class BOJ24480 {
    private static int N, M, R, cnt = 1;
    private static int[] visited;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(start).add(to);
            graph.get(to).add(start);
        }

        for(int i = 0 ; i < graph.size(); i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(R);

        for(int i = 1; i < visited.length; i++){
            System.out.println(visited[i]);
        }
    }
    private static void dfs(int vertex){
        visited[vertex] = cnt;
        for(int i = 0; i < graph.get(vertex).size(); i++){
            int v = graph.get(vertex).get(i);
            if(visited[v] == 0){
                cnt++;
                dfs(v);
            }
        }
    }
}

```

## 문제풀이
24479번과 똑-같은데 정렬만 오름차순 -> 내림차순 으로 바뀐 것

24479번을 어렵게 풀어냈던지라, 다시 새롭게 구현해보겠다는 마음..으로 생각 나는 것 + 다시 로직 짜내기를 하고 있었는데, 또 실패가 떠버렸다.ㅋㅋ 내림차순으로는 Collections.sort(graph.get(i), Collections.reverseOrder());으로 정렬해줬고..

어디가 틀렸을까 가만히 문제를 또 보니.. 무슨 생각으로 visited[1] = 1을 해두었던건지 모르겠는데, 시작 정점이 1이라고 하는 것에 또 꽂혔나보다.😅 이거 없애니 당연히.. 정상 동작!

오늘의 교훈 : '사람은 똑같은 실수를 반복한다'라는 말은 틀림이 없지만 반복하지 않기 위해 더 노력해보자!!
