# [9095] 1, 2, 3 더하기

## 분류
> 다이나믹 프로그래밍

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < dp.length; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
```

## 문제풀이

분명히 규칙이 있을거라 믿고 6까지 적었다....

1 = 1개
2 = 2개
3 = 4개
4 = 7개
5 = 13개
6 = 24개
7 = 44개
8 = 81개
9 = 149개
10 = 274개
...
n이 11 이하인 것은 확인을 못하고 했긴 했는데.. 
일단 이렇게 해서 dp[i] = dp[i-3] + dp[i-2] + dp[i-1]로 작성했다.
