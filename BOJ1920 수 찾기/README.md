# [1920] 수 찾기

## 분류
> 이분탐색
>

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		int [] B = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		for(int i = 0; i < M; i++) {
			res = bSearch(A, B[i]);
			bw.write(res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int bSearch(int[] A, int b) {
		int low = 0;// A의 왼쪽 끝 인덱스
		int high = A.length - 1;	//A의 오른쪽 끝 인덱스
		
		while(low <= high) {
			int mid = (low + high) / 2;
			if(A[mid] == b)
				return 1;
			else if(A[mid] > b)
				high = mid -1;
			else
				low = mid + 1;
		}
		return 0;
	}
}
```

## 문제풀이

이분탐색 문제. 알고리즘으로는 이분탐색을 처음 구현해보았다. 알고리즘이란 말을 붙여놔서 어려운 것 뿐이지, 개념 그대로 적용하면 된다. 

이분탐색은 우선 비교할 수들을 오름차순으로 정렬해야한다. 그래야 큰 지, 작은 지, 같은 지 비교해서 2등분 할 수 있다. 가장 처음엔 0부터 비교할 배열의 마지막 값의 인덱스까지를 비교한다. 반으로 나누었을 때, 더 작으면 왼쪽, 더 크면 오른쪽으로 가서 다시 비교해주면 된다.  

