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
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Arrays.sort(arr);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (isPrime(arr[i]))
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static public boolean isPrime(int a) {
		if (a == 1)
			return false;
		for (int i = 2; i < a; i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}
}
```

## 문제풀이

1은 소수가 아니므로 바로 제외하고, 2부터 비교할 수 -1 까지 반복문을 실행해 비교할 수를 i로 나누었을 때 나누어떨어지면 소수가 아니므로 모두 false로 바꾸어준다. 이 두가지가 아닌 경우는 모두 소수이므로 true를 리턴하도록 하면 된다.

Main에서 함수를 호출하고, 리턴된 boolean 값이 true일 때 cnt값을 증가시키고 반복문 실행이 끝나고 나면 cnt 값을 출력한다.