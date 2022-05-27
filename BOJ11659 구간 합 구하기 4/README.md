# [11659] 구간 합 구하기 4

## 분류
> 누적 합

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(arr[b] - arr[a-1]).append('\n');
		}
		System.out.println(sb);
	}
}
```

## 문제풀이

시간초과 한 번 난 문제. 실버3인걸 생각하고 풀었어야했는데 너무 쉽다 했다. 그냥 무턱대고 total에 쌓아버렸는데 바로 시간초과가 나서, 알고리즘 분류를 봤더니 '누적 합'이라고 되어있어서 규칙을 찾아야겠다 싶었다.

애초에 입력받을 때, 하나 하나 받는 게 아니라 누적해서 받아버리고 마지막에 구간 합을 구할 때는 쌓는게 아니라 딱 한 번만 계산하도록 해야 시간이 줄어든다.

조금 더 줄이려고 StringBuilder까지 사용해줬따..