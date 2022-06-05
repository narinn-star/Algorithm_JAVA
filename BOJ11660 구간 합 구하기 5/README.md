# [11660] 구간 합 구하기 5

## 분류
> 다이나믹 프로그래밍
>
> 누적 합

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
			}
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			sb.append(dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1]).append("\n");
		}
		System.out.println(sb);
	}
}
```

## 문제풀이

DP문제인 줄 모르고 한참 고민하고 고치길 거듭해서 맞힌 문제. 

처음엔 그냥 arr에 한 줄씩 누적 합으로 담았는데, (2, 2) ~ (3, 4)를 구할 때를 보면 (3, 1)은 포함시키지 않고 직사각형 모양의 합을 구해야하기 때문에 조건문을 달기엔 너무 까다로워졌다. 이때 구간 합 구하기 4랑은 조금 다르게 생각해야겠다는 생각을 했다.

알고리즘 분류를 보니 DP라고 되어있어서 처음부터 다시 생각해서 풀어냈다. 입력을 받아 그대로 표를 채워 놓고, dp 배열을 따로 만들어서 거기에 누적 합을 계산해 담았다. 왼쪽, 위를 더하고 왼쪽 상단에 있는 것을 뺀 후, 표에 있는 해당 자리 값을 더해 누적합을 계산했다. (x1, y1) ~ (x2, y2)를 계산해서 출력하면 맞게 나온다.