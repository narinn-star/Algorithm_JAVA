# [1010] 다리 놓기

## 분류
> 수학
>
> 다이나믹 프로그래밍
>
> 조합론

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double N = Double.parseDouble(st.nextToken());
			double M = Double.parseDouble(st.nextToken());
			double west = 1, east = 1;

				for (double i = M - N + 1; i <= M; i++) {
					east *= i;
				}
				for (double i = 1; i <= N; i++) {
					west *= i;
				}
				double res = east/west;
				System.out.printf("%.0f\n", res);
		}
	}

}

```

## 문제풀이

dp 말고 조합으로 풀었다. nCr 계산하는 게 이렇게 오래 걸릴 줄은 몰랐다. 틀린게 없는데 계속 'E'가 포함된 이상한 숫자가 출력되기도 하고, long이나 int를 사용하면 overflow가 나기도 했다. 

구글링 했을 때는 double을 사용하면 터지지 않는다고 했는데, 나는 계속 소숫점이 나오고 해서 더 찾아보니 출력함수를 printf()로 사용해야 한다고 한다.

로직이 어려운 게 아니라 출력문 하나 때문에 오래 고민했다.

