# [9663] N-Queen

## 분류
> 브루트포스 알고리즘
>
> 백트래킹

## 코드
```java
import java.io.*;

public class BOJ9663 {
    static int N, sum;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            visited = new boolean[N][N];
            visited[0][i] = true;
            dfs(1);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) {
        if (depth == N) {
            sum++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (checkQueens(j, depth)) {
                visited[depth][j] = true;
                dfs(depth + 1);
                visited[depth][j] = false;
            }
        }
    }

    static boolean checkQueens(int x, int depth) {
        for (int i = 0; i < depth; i++) {
            if (visited[i][x]) return false;
        }

        int tmpX = x - 1;
        int tmpY = depth - 1;

        while (tmpX >= 0 && tmpY >= 0) {
            if (visited[tmpY--][tmpX--]) return false;
        }

        tmpX = x + 1;
        tmpY = depth - 1;
        while (tmpX < N && tmpY >= 0) {
            if (visited[tmpY--][tmpX++]) return false;
        }

        return true;
    }
}
```

## 문제풀이

가장 어려웠던 점  

1. 어떻게 visited 배열을 초기화시킬 것인가?
2. 대각선은 어떻게 체크할 것인가?  

나머지는 백트래킹의 템플릿과 거의 동일했다. 가장 까다로웠던 게 여태껏 반복문은 1개로 사용했는데, 이번에는 2차원 배열에 visited 값을 담다보니 i와 j가 뒤섞여 back하는 방법이 너무 헷갈렸다.  
한참 고민하다 생각난 것이 N x N 판에 N개의 말이 올라가야하는데 퀸은 상하좌우로 같은 줄에는 절대로 하나 더 존재할 수 없으므로, 한 줄에 하나가 무조건 존재해야한다는 것이다. 그래서 반복문 하나를 main으로 빼줬다. 내 머리로는 그래야 visited를 초기화할 수 있다고 생각했기 때문.. 하나 체크 해줬으니 바로 다음 depth는 1부터 시작하면 된다. (0번 줄에 하나 넣어줬으니까)  

그 다음에는 한 줄씩 더 나아가면서 똑같이 dfs를 돌아주면 된다. 단, visited여부가 조건문에 들어가는 것이 아니라, 퀸이 존재할 수 있는 곳을 체크해 주는 함수의 리턴값이 true일 때 그 다음 퀸의 위치를 정해주면 된다.

checkQueens 함수는 내가봐도 구리다..... 저게 최선이었어
