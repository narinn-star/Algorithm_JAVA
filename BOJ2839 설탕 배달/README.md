# [2839] 설탕 배달

## 분류
> 수학
>
> 다이나믹 프로그래밍
>
> 그리디 알고리즘

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2839 {
	static int cnt, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		if(N == 4 || N == 7)
			bw.write("-1");
		else if (N % 5 == 0)
			bw.write(N / 5 + "\n");
		else if (N % 5 == 1 || N % 5 == 3)
			bw.write((N / 5) + 1 + "\n");
		else if (N % 5 == 2 || N % 5 == 4)
			bw.write((N / 5) + 2 + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

알고리즘을 새로 구성한다기 보다는 규칙을 찾아 5의 나머지가 0, 1, 2, 3, 4일때를 나누고 -1 나올 수 밖에 없는 수 4, 7을 찾아 또 따로 조건문을 걸어주면 된다.

처음엔 알고리즘을 구성하다가 계속 한가지씩 빠지는 경우가 생겨 하나씩 적어보니 규칙이 나오는 걸 알 수 있었다.