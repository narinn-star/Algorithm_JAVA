# [1904] 01타일

## 분류
> 다이나믹 프로그래밍

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 2];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		if (N == 1 || N == 2) {
			System.out.println(dp[N]);
		} else {
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
			}
			System.out.println(dp[N]);
		}
	}
}
```

## 문제풀이

N = 1부터 N = 6까지 갯수를 세어보면 피보나치처럼 dp[n] = dp[n-1] + dp[n-2]인 규칙을 찾을 수 있다. 

dp[0], dp[1], dp[2]를 모두 초기화해주기 때문에 처음에 배열을 선언할 때 N + 2로 해두어야한다. N이 1일때도 dp[2]까지 생성되기 때문.

두번째로 주의할 점은 dp[i]를 계산할 때 바로 15746으로 나누어주는 것. dp[i]가 Integer 범위를 넘을 수 있기 때문에 바로 나누어주어야 한다.