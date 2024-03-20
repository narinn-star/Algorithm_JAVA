# [11727] 2xn 타일링 2

## 분류
> 다이나믹 프로그래밍

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1])%10007;
        }

        System.out.println(dp[n]);
    }
}
```

## 문제풀이

n = 1 : 1
n = 2 : 3
n = 3 : 5
n = 4 : 11

여기까지만 구하고 예제에서 n = 8일 때 171, n = 12일 때 2731인 것을 참고해서 점화식을 얻어냈다.
dp[i] = dp[i - 2] x 2 + dp[i - 1];
을 알아냈다!

뭔가 노가다인 문제인데 경우의 수가 많아지니 하나라도 잘못 세는 순간 못 풀겠다 싶은.. 그런 느낌이다.
그리고 이렇게 규칙이 있는 문제는 보통 5-6까지 구하지 않아도 규칙이 나오는 것 같아서, 4까지만 구하고 뚫어져라 쳐다봤음.. 😝
