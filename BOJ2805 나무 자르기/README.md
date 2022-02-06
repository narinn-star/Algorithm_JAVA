# [2805] 나무 자르기

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

public class BOJ2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int max = 0;
		int min = 0;

		int[] tree = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());

			if (tree[i] > max) 				// 가장 높은 나무 찾기
				max = tree[i];
		}

		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0; 					
            // 최대 높이가 1,000,000,000이므로 합을 구하면 long타입이 필요

			for (int h : tree) {
				if(h - mid > 0)				//0, 음수일 때는 제외
					sum += (h - mid);
			}
			
			if(sum < M)
				max = mid;
			else
				min = mid + 1;
		}
		System.out.println(min - 1);
	}
}
```

## 문제풀이

어렵지 않은 이분탐색 문제!

주의할 점은 높이 만큼 나무를 가져가는 게 아니라 높이만큼 자르고 그 윗부분을 가져가는 것이 중요하다. 즉, 나무길이 - 높이를 한 만큼 가져갈 수 있다는 점만 유의하면 된다.

min은 0, max는 있는 나무들 중 가장 키가 큰 나무로 초기화하고, 반복문은 min < max일 때까지 계속 수행하도록 한다. mid는 중간값으로 해주고, sum은 long 타입으로 선언한다. 높이가 1,000,000,000 (10억)이 최대이므로, 나중에 합하다 보면 int형으로는 넘칠 수도 있기 때문에 overflow를 방지하기위해 우선 long으로 선언했다.

이제 나무를 자를 차례. 나무 하나씩 돌아가면서 mid값을 뺐을 때 0 이하인 수는 제외하고 sum에 합해준다. 이게 상근이가 가져갈 수 있는 나무 길이의 총 합이다. 나무 개수만큼 반복해주고 나서, sum이 M(가져갈 나무 길이)보다 작으면 높이를 더 낮추어야 (나무 길이 - 높이)가 더 커지기 때문에 상한선을 낮추어 주고, 반대로 sum이 M보다 크면 높이를 더 높여야 가져갈 나무 길이가 작아지기 때문에 하한선을 높여주면 된다.

마지막 출력에서 min - 1을 해주는 이유를 잘 몰랐는데, 이게 UpperBound 방식을 사용했기 때문이라고 한다. UpperBound 방식을 사용하면 최종값의 +1이 되기 때문에 원하는 값을 얻기 위해서는 -1을 해주어야 한다.