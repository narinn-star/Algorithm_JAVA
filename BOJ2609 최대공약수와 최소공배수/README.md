# [2609] 최대공약수와 최소공배수

## 분류
> 수학
>
> 정수론
>
> 유클리드 호제법

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = 0;
		int max = Integer.MIN_VALUE;

		if (a >= b)
			c = b;
		else
			c = a;

		for (int i = 1; i <= c; i++) {
			if (a % i == 0 && b % i == 0) {
				max = Math.max(max, i);
			}
		}
		bw.write(max + "\n");
		bw.write((a * b / max) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

최대공약수, 최소공배수 따로 반복문 실행해서 풀었는데 유클리드 호제법이란 다른 풀이법이 있어서 허탈하당..

최대공약수

더 작은 수 까지 반복문을 실행해서 둘 다 동시에 나누어떨어지는 가장 큰 수를 찾으면 된다.

최소공배수

'동시에' 라는 개념이 적용이 되지 않기 때문에 다른 방법을 통해 풀어야하는데 잘 해결되지 않아 구글링을 했다. 유클리드 호제법을 이용해 최대공약수를 구하고 나서 a*b를 최대공약수로 나누어주면 최소공배수를 구할 수 있다.