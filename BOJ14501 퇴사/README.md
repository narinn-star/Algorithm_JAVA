# [14501] 퇴사

## 분류
> 브루트포스 알고리즘
>
> 다이나믹 프로그래밍

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    public static int N;
    public static int T[];
    public static int P[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        int dp[] = new int[N+1]; // N일의 최대 수익

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()); // 기간
            P[i] = Integer.parseInt(st.nextToken()); // 금액
        }

        for(int i = 0; i < N; i++){
                if(i + T[i] <= N){  // 날짜가 N을 넘지 않으면
                    dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
                }
                dp[i+1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}
```

## 문제풀이
1. 날짜 계산
2. 최대 금액 계산

이렇게 생각하고.. 브루트포스만 생각하고 풀어내려고 했는데 생각처럼 잘 되지 않았다..
한시간 넘게 고민하다 다른 분의 풀이를 참고했다. (2년 전에 내가 푼 걸 봤지만 도대체 어떻게 풀었나 싶다.)

풀이를 보고서야 다이나믹 프로그래밍인걸 알았고, dp라면 점화식을 구해야한다는 생각이 가장 먼저 들었다. dp 배열에 담을 수는 당연히 백준이가 벌 수 있는 최대 이익이다.

1. 날짜가 N을 넘지 않을 때만 dp[]값이 변경되어야 한다. N을 넘기게 되면 어차피 상담을 할 수 없기 때문.
2. dp[0 + T[0]] = Math.max(dp[0 + T[0]], dp[0] + P[0])
    dp[3] = Math.max(dp[3], 0 + 10)
    dp[3] = 10
    
    dp[0 + 1] = Math.max(dp[0 + 1], dp[0])
    dp[1] = Math.max(0, 0)
    dp[1] = 0

이 과정을 N-1까지 반복하면

dp[] => 0 0 0 10 30 30 45 45
라는 결과를 얻을 수 있다.

음.. 아마 한 번 더 풀어보거나 dp를 조금 더 공부하고 다시 풀어봐야 제대로 이해할 수 있을 것 같다.
