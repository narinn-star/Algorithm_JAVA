# [2178] 미로 탐색

## 분류
> 그래프 이론
>
> 그래프 탐색
> 
> 너비 우선 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    private static int N, M;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs(0,0);

        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int x, int y){
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int X = qX + dx[i];
                int Y = qY + dy[i];

                if(X >= 0 && Y >= 0 && X < N && Y < M){
                    if(map[X][Y] == 1 && !visited[X][Y]){
                        queue.add(new int[]{X, Y});
                        map[X][Y] = map[qX][qY] + 1;
                        visited[X][Y] = true;
                    }
                }
            }
        }


    }
}
```

## 문제풀이

입력을 잘못받아서 한참 고생했음.. charAt(j)로 입력을 받아야하는데 charAt(i)로 입력을 받아서,, 인텔리제이에서는 변수에 밑줄이 쳐지는 경우가 있어서 헷갈렸음 ㅠㅠ 

나머지는 bfs로 푼 거라 그대로고, map 배열에 이동 횟수를 때마다 기록해줬다.

이렇게 템플릿이 정해진 문제를 계속 풀다보면, 쉽다가도,, 한 번 헷갈리면 템플릿에 맞춰 작성하던 습관 때문에 크게 흔들리는 경햐이 있는 것 같다. 풀어봤던 알고리즘이더라도 손으로 작성해보고 흐름에 맞춰 작성하는 게 좋을 것 같다는 생각을 했서요 ~,~

