# [9461] 파도반 수열

## 분류
> 수학
>
> 다이나믹 프로그래밍

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] arr = new long[102];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		
		for (int i = 4; i <= 100; i++) {
			arr[i] = arr[i - 3] + arr[i - 2];
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(arr[N]);
		}
	}
}
```

## 문제풀이

오랜만에 풀어본 DP. 

9개월 전엔 뭐가 뭔지 잘 모르고 하나씩 규칙 찾아서 풀었는데, 그래도 전공 수업 들었다고 뚝딱 풀어내는게 신기할 따름이다. 한 15개쯤 적어보면 규칙이 보여서 바로 풀었는데, 틀렸다고 떠서 반례를 찾아봤다. 100을 넣으면 수가 너무 커져서 담기질 않는 것.. int형이 아닌 long으로 바꿔서 제출하니 바로 정답이 떴다.