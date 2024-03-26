# [2667] 단지번호붙이기

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {
    private static int N, apartNum = 0;
    private static int home[][];
    private static boolean visited[][];
    private static int dx[] = {-1, 0, 1, 0}; // 상 우 하 좌
    private static int dy[] = {0, 1, 0, -1}; // 상 우 하 좌
    private static ArrayList apart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        home = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        apart = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                home[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (home[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    apartNum++; // 단지 수
                }
            }
        }

        Collections.sort(apart);
        System.out.println(apartNum);

        for(int i = 0; i < apart.size(); i++){
            System.out.println(apart.get(i));
        }

    }

    private static void bfs(int a, int b) {
        int cnt = 0;

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            cnt++;

            for (int i = 0; i < 4; i++) {
                int tempX = dx[i] + qX;
                int tempY = dy[i] + qY;

                if (tempX >= 0 && tempY >= 0 && tempX < N && tempY < N) {
                    if (home[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                        queue.add(new int[]{tempX, tempY});
                        visited[tempX][tempY] = true;

                    }
                }
            }
        }
        apart.add(cnt);
    }
}
```

## 문제풀이

이전엔 DFS로 풀었던 거라, BFS로 풀었다!

유기농 배추랑 문제가 거의 유사한데, 조금 더 심화해서 단지 내 아파트 수 세기가 추가된 문제다.

딱 '아파트 수 세기'를 어디서 해야할 지 고민을 조금 했다. 고민할 필요도 없이 while문 내에서 ++해주면 되는 거였지만... 어차피 bfs한 번 돌 때 한 단지 내를 도는 것이기 때문에 그 때 cnt++를 해주고, 새롭게 bfs함수에 들어올 때 cnt를 0으로 초기화했다. 그리고 bfs 함수를 빠져나가기 전에 리스트에 cnt값을 넣어줬다.

+ ArrayList => Collections.sort();
+ Array => Arrays.sort();
