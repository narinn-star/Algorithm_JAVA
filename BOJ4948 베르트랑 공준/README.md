# [4948] 베르트랑 공준

## 분류
> 수학
>
> 정수론
>
> 소수 판정
>
> 에라토스테네스의 체

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4948 {
	static	boolean[] prime = new boolean[123456*2 + 1];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		isPrime();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			int cnt = 0;
			
			for (int i = n + 1; i <= 2 * n; i++) {
				if (!prime[i])
					cnt++;
			}
			System.out.println(cnt);
		}
	}

	public static void isPrime() {
		prime[0] = prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) continue;
			for(int j = i*i; j< prime.length; j+= i) {
				prime[j] = true;
			}
		}
	}
}
```

## 문제풀이

오랜만에 시간초과. 사실 혼자 컴파일했을 때도 시간이 모자란 건 알고 있었는데, 에라토스테네스의 체를 검색하면 바로 정답이나올 것 같아서 양심적으로(?) 틀린 문제라고 생각해서 그냥 틀려버렸당

시간초과된 코드는 다음과 같다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			if (n == 0)
				break;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (isPrime(i))
					cnt++;
			}
			System.out.println(cnt);
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
```
n이 100000만 되어도 2n은 200000이기 때문에 너무 큰 숫자가 되어버려 시간초과가 나버린 것이다. 

에라토스테네스의 체를 이용하면 n의 제곱근만큼만 반복문을 돌기 때문에 시간이 많이 줄어든다. 이 점을 이용해서 문제를 푸는데, 

내가 풀었던 문제 [BOJ1929 소수 구하기](https://github.com/narinn-star/Algorithm_JAVA/tree/master/BOJ1929%20%EC%86%8C%EC%88%98%20%EA%B5%AC%ED%95%98%EA%B8%B0)

와 풀이가 같으므로 자세한 설명은 생략..!