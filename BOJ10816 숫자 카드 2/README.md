# [10816] 숫자 카드 2

## 분류
> 자료 구조
>
> 정렬
>
> 이분 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[20000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cnt[Integer.parseInt(st.nextToken()) + 10000000]++;
		}

		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			sb.append(cnt[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
		}
		System.out.println(sb);
	}
}
```

## 문제풀이

이분 탐색 문제인데 이분탐색으로 안풀었다. 아직 이분탐색 혼자서 뚝딱 풀어내는건 어려운 것 같아 그냥 counting 방식으로 풀었는데 두번이나 시간 초과가 떴다..

-10,000,000 ~ 10,000,000 만큼 입력할 수 있으니 일단 cnt 배열의 크기는 20,000,001만큼 해주고, 0 ~ 9,999,999 까지는 음수, 그 이상은 양수가 카운팅 되도록 한다.

for문 안에서 숫자 입력 받고, 그 숫자를 cnt 인덱스로 찾아 ++ 시켜주는 방법으로 했는데, 시간초과가 나서, 필요없는 상근이의 카드 배열과 체크 할 카드 배열 두개의 선언문과 입력받는 소스는 지워버리고, cnt 인덱스에서 바로 입력받았다.

그런데도 시간초과.. 이때까지 StringBuilder는 많이 봤는데, System.out.print() 때문에 시간초과가 뜬 적이 없어서 그냥 넘어갔었는데 계속 출력해주는 것과 모아뒀다가 한번에 출력하는 것의 시간 차이를 오늘 확실히 봐버렸다..