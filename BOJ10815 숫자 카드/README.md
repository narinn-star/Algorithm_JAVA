# [10815] 숫자 카드

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
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
	static int N;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(binary(card))
				sb.append("1").append(" ");
			else
				sb.append("0").append(" ");
		}
		System.out.print(sb);
	}
	private static boolean binary(int n) {
		int front = 0;
		int last = N - 1;
		
		while(front <= last) {
			int idx = (front + last)/2;
			int mid = num[idx];
			
			if(n < mid) last = idx - 1;
			else if(n > mid) front = idx + 1;
			else return true;
		}
		return false;
	}
}
```

## 문제풀이

예전에 이 문제 보고 이분 탐색으로 풀어야하는 이유를 몰라서 이분탐색 공부하고 나서 풀어보겠다며 넘겨뒀었는데, 이제야 풀었다..

먼저 가지고 있는 숫자 카드는 배열에 넣고 정렬시켜준다. 이분 탐색을 실행하기 위한 전제 조건 자체가 정렬되어있는 수를 요구하기 때문. 그리고 M개의 정수는 따로 배열에 담지 않고 하나를 입력 받을 때마다 바로 함수를 호출해서 상근이가 가지고 있는지 없는지를 확인한다. 

함수에서는 이분 탐색에서 필요한 front, last 그리고 mid를 사용하는데 mid의 인덱스 값을 계산하는 식이 반복되어 idx라는 인덱스 변수를 하나 더 만들어주긴 했으나.. 사실 이건 전혀 상관이 없다. 그저 내가 보기 편하려고 만든 변수이기 때문.. 

```java
// int idx = (front + last)/2;
int mid = num[(front + last)/2];		
if(n < mid) last = (front + last)/2 - 1;
else if(n > mid) front = (front + last)/2 + 1;
else return true;
```
이렇게 작성해도 상관 없다는 뜻. 어차피 front와 last는 while문을 빠져나가지 않는 한, 계속 갱신되기 때문에 전혀 문제가 되지 않는다.

이분탐색 방법에 맞게 front, last, mid를 변경해주고 찾았을 때 true, 찾지 못했을 때 false를 반환하고 1과 0을 알맞게 append한 뒤 출력하면 된다.

