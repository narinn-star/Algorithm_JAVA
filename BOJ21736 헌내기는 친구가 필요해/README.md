# [21736] 헌내기는 친구가 필요해

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
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21736 {
    static int N, M, cnt = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] campus;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        if (cnt == 0) {
            bw.write("TT");
        } else {
            bw.write(cnt + "");
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int tmpX = qX + dx[i];
                int tmpY = qY + dy[i];

                if (tmpX < 0 || tmpY < 0 || tmpX >= N || tmpY >= M || visited[tmpX][tmpY] || campus[tmpX][tmpY] == 'X')
                    continue;

                if (campus[tmpX][tmpY] == 'P') {
                    cnt++;
                }
                queue.add(new int[]{tmpX, tmpY});
                visited[tmpX][tmpY] = true;
            }
        }
    }
}
```

## 문제풀이

bfs문제.  

지금 다시 코드를 보니, while문 내에서 x를 걸러내는 대신, visited에 false를 사전에 넣어두는 방법이나 visited를 없애고 방문한 곳을 X로 모두 처리하는 게 메모리도 그렇고 더 좋을 것 같다는 생각을 했다.  

템플릿이 정해져있는 문제다보니, 급하게 풀면 poll 하는 것이라던지.. 그런 작은 것들을 빼먹곤 한다. 조금만 더 생각이라는 걸 해보쟈 ,,🫠
