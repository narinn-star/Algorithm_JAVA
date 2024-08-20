# [9465] 스티커

## 분류
> 다이나믹 프로그래밍

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for(int i = 2; i <= N; i++){
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
```

## 문제풀이

50 10 100 20 40    
30 50 70 10 60  

처음 찾은 규칙은 다음과 같다.
첫번째로 고를 숫자는 둘 중 아무것이어도 상관없다.  
50을 골랐을 때, 그 다음으로 갈 수 있는 곳을 생각했다. 그럼 50, 100, 70 세 곳이 있다. 뛰어 넘고 가는 경우는 없다. 하나라도 밟고 가야 최댓값을 가져갈 수 있기 때문이다. 50과 100을 더하면 70보다 크기 때문에, 70으로 바로 가는 방법보다는 50을 먼저 가는 것이 이득이다. 이를 계속 반복한다.
그리고 30을 골랐을 때도 위와 같이 진행한 후, 마지막에 두 값을 비교해 더 큰 값을 찾고자 했다.  
이 방법을 사용했을 때, 끝으로 가면서 인덱스 범위를 체크해야하는 일이 생긴다.  
체크해야할 인덱스 최대 거리(?)는 2로, 차라리 2번째 줄부터 비교하는게 낫겠다 생각했다. [0][0]과 [1][0]은 비워 0으로 두고 (더해도 상관 없는 값), [0][1]과 [1][1]에 첫번째 값들을 넣었다. 2부터 반복문을 돌면서 값을 쌓아줬다. 원리는 비슷하다. 초기화된 값은 다음과 같다.   
0 50 10 100 20 40    
0 30 50 70 10 60  

[0][2]자리에 들어갈 수 있는 값은 [0][2]자리의 값에 [1][0], [1][1]중 큰 값을 더해주는 것이다. [0][0]자리가 필요없는 이유는 [1][1]을 선택했다면 [0][0]은 선택되었거나 선택되지 않거나 이미 확인된(?)값이기 때문이다. 

