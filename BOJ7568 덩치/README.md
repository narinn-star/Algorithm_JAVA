# [7568] 덩치

## 분류
> 구현
>
> 브루트포스 알고리즘

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N + 1];
		int[] height = new int[N + 1];
		int[] cnt = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (weight[i] < weight[j] && height[i] < height[j]) {
					cnt[i]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(cnt[i] + 1 + " ");
		}
	}
}
```

## 문제풀이

9달 전, 알고리즘 스터디 할 때 풀었던 문제. 뭣도 모르고 이렇게 하면 되는건가 싶어서 뚝딱거리면서 풀었는데 그래도 이전보다는 실력이 늘었는지 물흐르듯 잘 풀었다.

브루트포스는 하나씩 모두 비교해보고 정답을 도출하는 알고리즘이라 그리 어렵지 않다. 그냥 배열으로 모두 풀어냈다. 

이전에 풀었던 것을 잠깐 펼쳐봤는데, 키와 몸무게를 이차원 배열 하나에 모두 다 넣고 비교를 했었다. cnt 배열 대신에 변수 하나로 그냥 쌓고 바로 출력하는 방법으로 풀었다. 이번에 푼 코드가 시간이 더 짧게 걸렸따.