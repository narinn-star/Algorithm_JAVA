# [11726] 2xn 타일링

## 분류
> 다이나믹 프로그래밍

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1])%10007;
        }

        System.out.println(dp[n]);
    }
}

```

## 문제풀이

n = 1 : 1
n = 2 : 2
n = 3 : 3
n = 4 : 5
n = 5 : 8
...
i = (i - 2) + (i - 1)인 것을 바로 알 수 있다.

하나 문제는 출력할 때 10007로 나누는 것이 아니라 반복문 내에서 10007로 나누어주어야 하는 것인데, 
반복문 내에서 10007로 나누면 dp배열에 잘못된 값이 저장되는 것이 아닐까 했지만.. 20까지 해보니 그래도 똑같았다. 찾아보니 출력할 때 10007로 나누면 배열에 너무 큰 값이 들어있어 잘못된 값이 출력될 수 있다고 한다.. 

