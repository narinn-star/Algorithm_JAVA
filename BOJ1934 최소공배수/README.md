# [1934] 최소공배수

## 분류
> 수학
>
> 정수론
>
> 유클리드 호제법

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);

			int d = gcd(A, B);

			sb.append(A * B / d).append("\n");
		}
		System.out.println(sb);
	}

	public static int gcd(int A, int B) {
		while (B != 0) {
			int r = A % B;

			A = B;
			B = r;
		}
		return A;
	}
}
```

## 문제풀이

그놈의 유클리드 호제법.. 

유클리드 호제법의 정의는 다음과 같다.

**두 수 a, b ∈ ℤ 이고, r = a mod b 이라고 한다. (r 은 a에 b를 나눈 나머지를 의미)**

**이 때 r은 (0 ≤ r < b) 이고, a ≥ b 이다.**

먼저 최대공약수를 구해주고 나서 입력받은 두 수의 곱에서 최대공약수를 나누어주면 최소공배수가 나오게 된다.

최대공약수를 구하는 함수는 따로 작성하고, 리턴값으로 입력값 두 수의 곱을 나누어주면 됨.