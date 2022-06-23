# [2525] 오븐 시계 

## 분류
> 수학
>
> 사칙연산

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int C = Integer.parseInt(br.readLine());

		B += C;
		int D = C / 60;
		for (int i = 0; i <= D; i++) {
			if (B > 59) {
				A++;
				B = B - 60;
			}
		}
		if (A > 23) {
			A = A - 24;
		}
		System.out.println(Math.abs(A) + " " + Math.abs(B));
	}
}
```

## 문제풀이

간단한 시계 만들기.

B = 60 - B라 작성해서 계속 마이너스 값이 나와 한 번밖에 분 계산이 되지 않았다.

B = B - 60 [고친 후]