# [Programmers 게임 맵 최단거리] 

## 분류
> 깊이/너비 우선 탐색(DFS/BFS)

## 코드
```java
import java.util.*;

class Solution {
    private static int n, m;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] visited;
    
    public int solution(int[][] maps) {        
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        
        bfs(0, 0, maps);
    
        if(visited[n - 1][m - 1] == 0) return -1;
        else return visited[n - 1][m - 1];
    }
    
    private static void bfs(int x, int y, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = 1;
        
        while(!queue.isEmpty()){
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++) {
                int X = qX + dx[i];
                int Y = qY + dy[i];

                if(X < 0 || X >= n || Y < 0 || Y >= m) continue;

                if(visited[X][Y] == 0 && maps[X][Y] == 1){
                    visited[X][Y] = visited[qX][qY] + 1;
                    queue.add(new int[]{X, Y});
                }
            }
        }
    }
}
```

## 문제풀이

오랜만에 푼 BFS문제. 

그냥 단순히 BFS가 아니라, 이렇게 쌓아가는(?)문제가 나오면 감은 바로 오는데 인덱스가 헷갈려서 꼭 한 번쯤은 틀리게 된다..

그래서 maps에 쌓지 않고 그냥 visited를 boolean으로 안하고 값을 쌓는 용도로 사용했다. 

BFS 푸는 템플릿은 정해져있으니까 따로 풀이는 적지 않게따
