# [10026] 적록색약

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

public class BOJ10026 {
    private static int N;
    private static int generalCnt, disabledCnt;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] grid;
    private static boolean[][] visited;
    private static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new char[N + 1][N + 1];
        visited = new boolean[N+1][N+1];
        generalCnt = disabledCnt = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j, grid[i][j]);
                    generalCnt++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 'R') grid[i][j] = 'G';
            }
        }

        visited = new boolean[N+1][N+1];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j, grid[i][j]);
                    disabledCnt++;
                }
            }
        }

        System.out.println(generalCnt + " " + disabledCnt);
    }

    private static void bfs(int x, int y, char c) {
        queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int X = queue.peek()[0];
            int Y = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int tempX = dx[i] + X;
                int tempY = dy[i] + Y;

                if(tempX >= 0 && tempY >= 0 && tempX < N && tempY < N){
                    if(grid[tempX][tempY] == c && !visited[tempX][tempY]){
                        visited[tempX][tempY] = true;
                        queue.add(new int[]{tempX, tempY});
                        bfs(tempX ,tempY, c);
                    }
                }
            }
        }
    }
}
```

## 문제풀이

단순하지 않은 것 같았지만 생각보다 너무 단순했던 문제!

시행착오를 겪은 것 하나를 적자면 red, blue, green을 따로 카운팅했던 것인데 지금 다시 생각해보니 말도 안되긴 하다..
그냥 단순하게 배열을 변경시켜주고 각각 bfs 함수를 실행해줬다. 이전 bfs 문제와 달랐던 것은 파라미터 값을 하나 더 추가해줬다는 것 정도? 다른 bfs랑 다를 게 없어서 따로 적을 풀이는 없음..

🍯골드5였던 게 틀림없음
