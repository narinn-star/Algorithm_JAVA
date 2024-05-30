# [5212] 지구 온난화

## 분류
> 구현
> 
> 시뮬레이션

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5212 {
    private static int R, C;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] map, resMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int minR = R, minC = C, maxR = 0, maxC = 0;
        map = new char[R][C];
        resMap = new char[R][C];

        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < R; i++){
            Arrays.fill(resMap[i], '.');
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'X'){
                    int islandCnt = 0;
                    for(int k = 0; k < 4; k++){
                        int X = i + dx[k];
                        int Y = j + dy[k];

                        if(X < R && Y < C && X >= 0 && Y >= 0 && map[X][Y] == 'X') islandCnt++;
                    }
                    if(islandCnt >= 2) resMap[i][j] = 'X';
                }
                if(resMap[i][j] == 'X'){
                    minR = Math.min(i, minR);
                    minC = Math.min(j, minC);
                    maxR = Math.max(i, maxR);
                    maxC = Math.max(j, maxC);
                }
            }
        }

        for(int i = minR; i <= maxR; i++){
            for(int j = minC; j <= maxC; j++){
                 System.out.print(resMap[i][j]);
            }
            System.out.println();
        }
    }
}
```

## 문제풀이

먼저 바다로 다 채워두고 4방향을 모두 탐색해 섬 갯수를 카운팅하고 섬 갯수가 2개 이상이면 가라앉지 않는다 판단했다. 배열 하나로 풀면 기존 배열이 망가져 다음 탐색 시에 영향을 미치기때문에 두개의 배열을 사용했다.

출력은 시작 좌표값과 끝 좌표값을 모두 구해 반복문을 실행해 출력했다. 

풀이를 작성하고 나니 정말 별거아닌 문제같은데, 출력에서 막혀서 오래 고민했다. 바다를 없애는 게 너무 어려웠는데,, 좌표 시작값과 끝값만 구해주면 되는 거였슴...
