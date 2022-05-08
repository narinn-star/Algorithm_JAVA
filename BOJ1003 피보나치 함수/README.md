# [1003] 피보나치 함수

## 분류
> 다이나믹 프로그래밍

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] fibo0 = new int[41];
		int[] fibo1 = new int[41];

		fibo0[0] = 1;
		fibo0[1] = 0;
		fibo1[0] = 0;
		fibo1[1] = 1;
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 2; i <= N; i++) {
				if (i == 2) {
					fibo0[i] = 1;
					fibo1[i] = 1;
				} else {
					fibo0[i] = fibo0[i - 1] + fibo0[i - 2];
					fibo1[i] = fibo1[i - 1] + fibo1[i - 2];
				}
			}
			System.out.println(fibo0[N] + " " + fibo1[N]);
		}
	}
}
```

## 문제풀이

그냥 재귀로 풀었다가 시간초과가 나서 dp로 다시 풀었다.

N이 0, 1, 2일때는 그냥 값을 대입해주고 3부터는 피보나치 규칙을 그냥 배열에 대입해서 값을 쌓아줬다. 분명히 풀기 시작했을때는 이렇게 풀려고 했는데, 계속 재귀로 피보나치를 풀다보니 자연스럽게 그냥 재귀로 풀었던 듯..