# [10953] A + B - 6

## 분류
> 수학
>
> 문자열
>
> 사칙연산
>
> 파싱

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split(",");
			sb.append(Integer.parseInt(input[0]) + Integer.parseInt(input[1])).append('\n');
		}
		System.out.println(sb);
	}
}
```

## 문제풀이

StringTokenizer로 "," 기준으로 잘라서 읽도록 했는데 자꾸 오류가 나서 그냥 한 줄 입력 받고 split()으로 잘라 배열에 담았다. 주의 해야할 점은 String형으로 받았기 때문에 Integer 정수형으로 파싱해주어야 하는 것.

나머지는 그냥 더해주는 것이기 때문에 신경써줘야할 부분은 없다.