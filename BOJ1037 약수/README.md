# [1037] 약수

## 분류
> 수학
>
> 정수론

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, num[i]);
			max = Math.max(max, num[i]);
		}
		System.out.print(min * max);
	}
}
```

## 문제풀이

예제들을 보면 맨 앞과 맨 뒤를 곱하면 N이 나오게 되는 것을 알 수 있다. 가장 가운데 두 수를 곱해도 N이 나오는데, 이를 위해 min과 max 변수를 선언하여 하나씩 입력받을 때마다 가장 작은 값과 가장 큰 값을 초기화한다. 

3 4 2 12 6 8 을 예로 들면, 최종적으로 min값은 2, max 값은 12로 N은 이 두 값을 곱한 24가 답이 되는 것.