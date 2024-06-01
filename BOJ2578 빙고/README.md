# [2581] 소수

## 분류
> 구현
> 
> 시뮬레이션

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2578 {
    private static int[][] bingo, input;
    private static int bingoCnt, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        bingo = new int[5][5];
        input = new int[5][5];
        cnt = 0;
        bingoCnt = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());

                check(input[i][j]);

                if (bingoCnt >= 3) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }

    private static void check(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (num == bingo[i][j]) {
                    bingo[i][j] = -1;
                    cnt++;
                }
            }
        }

        bingoCnt = 0;
        horizontalCheck();
        verticalCheck();
        diagonalLeftCheck();
        diagonalRightCheck();
    }

    private static void horizontalCheck() {
        for (int i = 0; i < 5; i++) {
            int tmpCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == -1) tmpCnt++;
            }
            if (tmpCnt == 5) bingoCnt++;
        }
    }

    private static void verticalCheck() {
        for (int i = 0; i < 5; i++) {
            int tmpCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == -1) tmpCnt++;
            }
            if (tmpCnt == 5) bingoCnt++;
        }
    }

    private static void diagonalLeftCheck() {
        int tmpCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == -1) tmpCnt++;
        }
        if (tmpCnt == 5) bingoCnt++;
    }

    private static void diagonalRightCheck() {
        int tmpCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == -1) tmpCnt++;
        }
        if (tmpCnt == 5) bingoCnt++;
    }
}

```

## 문제풀이

빙고문제를 그대로 풀어내는 구현 문제다. 가로, 세로, 대각선 두개를 확인하는 함수를 작성하면 빙고를 확인할 수 있어서 어렵지 않았다.

한 가지 헤맸던 부분은 bingoCnt값을 0으로 초기화해주지 않아서 생겼다. 가로/세로/대각선 빙고를 확인하기 이전에 당연히 0으로 초기화 되어 있어야 이전 값들이 중복되지 않아서 올바른 값이 나온다.
