# [1929] 소수 구하기

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
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1929 {
	static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		prime = new boolean[M + 1];
		notPrime();

		for (int i = N; i <= M; i++) {
			if(!prime[i])
				bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static public void notPrime() {
		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}
```

## 문제풀이

처음에 소수 판별을 해주는 알고리즘을 직접 작성했는데 시간초과가 떴다. 

에라토스테네스의 체를 쓰지 않으면 계속 시간초과가 뜰 것 같아서 구글링하여 에라토스테네스의 체 공식을 참고해서 풀었다. 잘 쓰지 않는 반복문 형식이라 조금 당황했지만 딱히 어려운 문제는 아니었던 것 같다. 

에라토스테네스의 체 공식은 2의 배수, 3의 배수, 5의 배수를 계속해서 지워나가고 이 방법을 다음에 지울 소수의 제곱이  N보다 커질때까지 계속한다. 그렇게 되면 배열이 true, false로 알맞게 저장되고 마지막에 소수만 출력해주면 된다.