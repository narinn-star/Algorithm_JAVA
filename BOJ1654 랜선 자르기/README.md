# [1654] 랜선 자르기

## 분류
> 이분 탐색
>
> 매개 변수 탐색

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] kLine = new int[K];
		long max = 0, mid = 0, min = 0;
		
		for(int i = 0; i < K; i++) {
			kLine[i] = Integer.parseInt(br.readLine());
			if(max < kLine[i])
				max = kLine[i];
		}
		
		max++;									//0으로 나누어지는 것 방지
		
		while(min < max) {
			mid = (min + max) / 2;
			long cnt = 0;
			
			for(int i = 0; i < kLine.length; i++) {
				cnt += (kLine[i] / mid);
			}
			
			if(cnt < N) 
				max = mid;
			else
				min = mid + 1;
		}
		
		System.out.println(min - 1);
	}
}
```

## 문제풀이

어렵지 않은 이분탐색 두번째 문제!

이전에 풀었던 나무 자르기와 거의 비슷한 문제였는데, 중간에 0으로 나누어지는 경우만 주의해서 잘 작성하면 된다. max++ 부분이 그 부분이다. 

이부분만 빼고는 특정 개수에 대한 특정 길이를 찾는 문제로, 나머지 모두 나무 자르기와 똑-같다. 