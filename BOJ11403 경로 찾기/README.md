# [11403] 경로 찾기

## 분류
> 그래프 이론
>
> 그래프 탐색
> 
> 최단 경로
> 
> 플로이드-워셜

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11403 {
    private static int N;
    private static boolean[] visited;
    private static int[][] graph;
    private static int[][] result;

    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        result = new int[N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int x) {
        queue = new LinkedList<>();
        queue.add(x);

        while(!queue.isEmpty()){
            int q = queue.poll();
            for(int i = 1; i <= N; i++){
                if(graph[q][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    result[x][i] = 1;
                }
            }
        }
    }
}

```

## 문제풀이

떠오르는 대로 큐에 넣고 빼줬다.. 1에서 갈 수 있는 모든 곳 (끝까지)을 체크해서 1로 넣어주고, 2에서 또 갈 수 있는 모든 곳을 체크해서 1로 넣어주고.. 이걸 N까지 반복했다. 하나 주의할 점은 visited 배열을 bfs를 호출할 때마다 초기화해줘야한다는 것이다. 한 번 돌면서 다 방문 처리가 되어있기 때문에 다시 리셋 해주는 것.

어찌저찌 풀어내긴 했고 답도 나오긴 했는데, 풀고 나서 플로이드-워셜이라는 새로운 알고리즘을 알게돼서 다른 사람이 이 문제를 어떻게 풀었는지 찾아봤다. 
너무 단순해서 어이가 없었지만..
i -> j == i -> k, k -> j
이게 끝이었다. 

거쳐가는 정점인 k를 기준으로 해두고 [i][k] == 1, [k][j] == 1인 경우가 [i][j] = 1인 것..

너무너무너무너무 쉬운 문제였다는 것.. 정답률이 60퍼센트가 넘는 게 말이 되는 것이었다 ...
