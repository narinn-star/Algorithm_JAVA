# [2096] 내려가기

## 분류
> 다이나믹 프로그래밍
>
> 슬라이딩 윈도우

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ2096 {
    static int N;
//    static int min = Integer.MAX_VALUE;
//    static int max = Integer.MIN_VALUE;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[N + 1][3];
        int[][] min = new int[N + 1][3];

        for(int i = 1; i <= N; i++){
            max[i][0] += Math.max(max[i - 1][0], max[i - 1][1]) + board[i][0];
            max[i][1] += Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + board[i][1];
            max[i][2] += Math.max(max[i - 1][1], max[i - 1][2]) + board[i][2];

            min[i][0] += Math.min(min[i - 1][0], min[i - 1][1]) + board[i][0];
            min[i][1] += Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + board[i][1];
            min[i][2] += Math.min(min[i - 1][1], min[i - 1][2]) + board[i][2];
        }

//        for(int i = 0; i < 3; i++){
//            dfs(0, i, board[0][i]);
//        }
        int resMin = Integer.MAX_VALUE;
        int resMax = Integer.MIN_VALUE;

        for(int i = 0; i < 3; i++){
            resMin = Math.min(resMin, min[N][i]);
            resMax = Math.max(resMax, max[N][i]);
        }

        bw.write(resMax + " " + resMin);
        bw.flush();
        bw.close();
        br.close();
    }
//    static void dfs(int depth, int y, int sum) {
//        if (depth == N - 1) {
//            min = Math.min(min, sum);
//            max = Math.max(max, sum);
//            return;
//        }
//
//        if (y == 0) {
//            //아래, 오른쪽 아래
//            dfs(depth + 1, y, sum + board[depth + 1][y]);
//            dfs(depth + 1, y + 1, sum + board[depth + 1][y + 1]);
//        } else if (y == 1) {
//            //왼쪽 아래, 아래, 오른쪽 아래
//            dfs(depth + 1, y - 1, sum + board[depth + 1][y - 1]);
//            dfs(depth + 1, y, sum + board[depth + 1][y]);
//            dfs(depth + 1, y + 1, sum + board[depth + 1][y + 1]);
//        } else if (y == 2){
//            //왼쪽 아래, 아래
//            dfs(depth + 1, y - 1, sum + board[depth + 1][y - 1]);
//            dfs(depth + 1, y, sum + board[depth + 1][y]);
//        }
//    }
}
```

## 문제풀이

알고리즘 분류를 안보고 풀었다. 처음에 내가 선택한 방법은 재귀로, y의 값에 따른 방향을 모두 탐색해 재귀호출을 했다. 사실 N이 100000까지인 걸 보고 재귀를 멈춰야했는데..ㅎ😅 당연히 시간초과가 나왔다. (반례는 모두 맞았음. 아마 N이 너무 커서 재귀로 풀 수 없는듯 하다.)

문제를 읽으면서 가장 먼저 떠올랐던 건 값을 쌓아가는 dp였는데, 계속 값이 바뀌기도 하고 계속 더하면서 내려갔을 때 오류 없이 최소,최대 값을 다 구할 수 있는가 라는 의심이 들어서 재귀를 선택한 것이었다. 재귀 방법이 틀리고 나니 사실 선택의 여지가 없었음.. 바로 dp로 풀었다. 인덱스 탐색을 쉽게 하기 위해서 1부터 N까지로 정했고, dp로 쌓아서 내려가면 된다. 하나가 아닌 max, min 따로 배열을 두고 값을 가져가면 계속해서 최대이거나 최소인 값을 구할 수 있다.
