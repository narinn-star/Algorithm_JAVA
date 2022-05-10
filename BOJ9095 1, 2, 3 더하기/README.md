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
		
		for(int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
```

## 문제풀이

1, 2, 3, 4까지만 적어보면 쉽게 규칙을 찾을 수 있다.

1 = (1)  

2 = (1 + 1, 2)

3 = (1 + 1 + 1, 1 + 2, 2 + 1, 3)

4 = (1 + 1 + 1 + 1, 1 + 1 + 2, 1 + 2 + 1, 2 + 1 + 1, 2 + 2, 1 + 3, 3 + 1)

dp[4] = dp[1] + dp[2] + dp[3]이므로, 4부터 11까지 반복문을 실행해주면 끝.