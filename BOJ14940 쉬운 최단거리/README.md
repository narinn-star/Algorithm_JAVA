# [14940] 쉬운 최단거리

## 분류
> 그래프 이론
>
> 그래프 탐색
> 
> 너비 우선 탐색

## 코드
```java
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0, startY = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    map[i][j] = 0;
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && !visited[i][j])
                    map[i][j] = -1;
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int tmpX = qX + dx[i];
                int tmpY = qY + dy[i];

                if(tmpX >= 0 && tmpY >= 0 && tmpX < n && tmpY < m){
                    if(!visited[tmpX][tmpY] && map[tmpX][tmpY] != 0){
                        map[tmpX][tmpY] = map[qX][qY] + 1;
                        queue.add(new int[] {tmpX, tmpY});
                        visited[tmpX][tmpY] = true;
                    }
                }
            }
        }
    }
}
```

## 문제풀이

시작점으로부터 모든 지점 까지의 거리를 구하는 문제다. 0으로 되어있는 곳은 지나갈 수 없고, 지나가지 못한 지점은 -1로 출력한다.   
시작점은 거리가 0이므로, 시작점(2)를 찾으면 바로 0으로 넣어두고 시작 지점 좌표도 저장한다.
각 지점까지의 거리를 구하기 위해 BFS를 선택했고, 시작 지점을 큐에 넣으면서 시작했다. 내부 값이 변하는 것을 고려하면 visited가 필요없을 수 있지만, 직관적으로 보기 편하게 visited 배열도 넣어서 체크했다. 도착한 곳에는 이전 지점에서 +1 한 값을 넣어주고, 큐에 넣어주면 된다.  
끗..
