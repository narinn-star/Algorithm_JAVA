# [1012] 유기농 배추

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

public class BOJ1012 {
    private static int T, M, N, K;
    private static int cabbage[][];
    private static boolean check[][];

    private static int x[] = {-1, 0, 1, 0}; // 상 우 하 좌
    private static int y[] = {0, 1, 0, -1}; // 상 우 하 좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cnt = 0;

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbage = new int[M + 1][N + 1];
            check = new boolean[M+1][N+1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                cabbage[a][b] = 1;
            }

            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(cabbage[i][j] == 1 && !check[i][j]){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int a, int b){
        check[a][b] = true;

        for (int i = 0; i < 4; i++){
            int tempX = a + x[i];
            int tempY = b + y[i];

            if(tempX >= 0 && tempY >= 0 && tempX < M && tempY < N){
                if(cabbage[tempX][tempY] == 1 && !check[tempX][tempY]){
                    bfs(tempX, tempY);
                }
            }
        }

    }
}
```

## 문제풀이

일단 풀이 템플릿은 머리에 들어있어서 어렵진 않았다. bfs로 풀려고 했는데 알고 보니 dfs로 풀었다는 게 웃길 뿐..

bfs로 풀려면 큐에 넣었어야죠?

그래서 bfs로 풀자면 bfs함수 안에서 
Queue<int[]> queue = new LinkedList<int[]>();
queue.add(new int[] { x, y });
를 해두고

큐에 아무것도 없을 때까지 빼고 넣고를 또 반복해주면 되는 것..!
x = queue.peek()[0]; y = queue.peek()[1]; queue.poll();
머 이렇게..?

그리고 나중에 조건문 내에서 queue.add(new int[] { tempX, tempY });를 해주면 되겠조 ??

점점 dfs랑 bfs는 알고리즘이 아니라 정해진 템플릿 안에 꾸겨넣기가 되어가고 있는 것 같아 걱정이다...
며칠 뒤에 골드 풀어 볼 예정인데 뭐가 많이 다르겠지..?
