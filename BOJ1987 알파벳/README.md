# [1987] 알파벳

## 분류
> 그래프 이론
>
> 그래프 탐색
>
> 깊이 우선 탐색
>
> 백트래킹

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1987 {
    static int R, C, max = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] alpha;
    static boolean[] alphaVisited = new boolean[26];
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                alpha[i][j] = line.charAt(j);
            }
        }

        alphaVisited[alpha[0][0] - 65] = true;
        alpha[0][0] = 'a';
        
        dfs(0, 0, 1);
        
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int depth) {

        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            if (tmpX >= 0 && tmpY >= 0 && tmpX < R && tmpY < C) {
                char tmpChar = alpha[tmpX][tmpY];
                if (tmpChar != 'a' && !alphaVisited[tmpChar - 65] ) {
                    alphaVisited[tmpChar - 65] = true;
                    alpha[tmpX][tmpY] = 'a';
                    
                    dfs(tmpX, tmpY, depth + 1);
                    
                    alphaVisited[tmpChar - 65] = false;
                    alpha[tmpX][tmpY] = tmpChar;
                }
            }
        }
        max = Math.max(max, depth);
    }
}
```

## 문제풀이

2년 전에 풀다가 그만둔 문제..! 드디어 풀었듭니다 ~ 👏🏻  

종료를 어떻게 시켜야할 지 가장 많이 고민했는데, 디버깅 돌리면서 딱히 종료시킬 필요가 없다고 생각했다. 왜냐하면 이전에 갔던 장소도 'a'를 넣으면서 방문 처리를 해줬고, 알파벳도 26개 배열로 방문 처리도 해줬고 게다가 4방향을 모두 탐색하면 for문은 자동으로 종료된다. 네 방향 모두 갈 곳이 없다면 거기가 바로 끝나는 지점이니까 반복문이 끝나고 max값을 갱신해주면 된다.  
이때 count를 올려줄까 했지만, 그럴 필요도 없이 depth를 세어주면 되니까 변수도 하나 더 선언할 필요가 없었다. 방문 처리를 해줘야 할 게 2개가 되었을 뿐, 다른 문제랑 크게 차이를 못느꼈다. 많이 늘었다는 거겠지 ?😳
