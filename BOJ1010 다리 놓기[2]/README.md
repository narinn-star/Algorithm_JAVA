# [1010] 다리 놓기

## 분류
> 수학
>
> 다이나믹 프로그래밍
>
> 조합론

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int array[][] = new int[30][30];

        for (int i = 0; i < 30; i++) {
                array[i][i] = 1;
                array[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for(int j = 1; j < 30; j++){
                array[i][j] = array[i - 1][j - 1] + array[i-1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(array[M][N]);
        }
    }
}

```

## 문제풀이

이전에 풀었던 방법은 조합을 사용해 풀었던데.. 이번에는 그 방법이 바로 떠오르진 않고, 일정한 규칙이 있을거라 생각해서 N이 4, M이 6인 경우까지 하나씩 구해보았다. 어떻게 보면 시간낭비나 너무 구식이라 생각되긴 하지만.. 일단 dp는 점화식이 중요하다 생각되어서 무작정 구해봤다.

그 결과
1 -> 1 : 1 | 2 -> 2 : 1 | 3 -> 3 : 1 | 4 -> 4 : 1
1 -> 2 : 2 | 2 -> 3 : 3 | 3 -> 4 : 4 | 4 -> 5 : 5
1 -> 3 : 3 | 2 -> 4 : 6 | 3 -> 5 : 10 | 4 -> 6 : 15
...

이렇게 결과가 나왔다. 4 -> 6을 보면 3 -> 5 : 10 + 4 -> 5 : 5 인것을 알 수 있었고, 
그 이하의 경우에도 array[i][j] = array[i - 1][j - 1] + array[i-1][j]; 이와같은 점화식이 적용되는 것을 알 수 있었다.

N과 M은 30이 최대이므로, 30 x 30을 미리 다 구해두고 찾아가는 방식을 선택했다.
