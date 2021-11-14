# [2475] 검증수

## 분류
> 브루트포스 알고리즘

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		int sum = 0, tmp = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N-2; i++) {
			for(int j = i + 1; j < N-1; j++) {
				for(int k = j + 1; k < N; k++) {
					tmp = card[i] + card[j] + card[k];
					if(tmp == M)
						sum = tmp;
					
					if(sum < tmp && tmp < M)
						sum = tmp;
				}
			}
		}

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

N개 중에 합이 M이 넘지 않는 가장 큰 카드 3장을 고르는 간단한 문제. 처음엔 N-2만큼 중에 하나, 그 다음엔 N-1중에 하나, 마지막엔 N 중에 하나 고르면 총 세장을 고를 수 있는데 이 때 중복은 안되기 때문에 시작 범위를 이전 카드 인덱스 +1이어야 한다.

만약 M과 합이 같다면 그대로 출력하면 되고, 그게 아니라면 계속해서 카드를 다시 뽑는데, 현재 뽑은 3장의 합이 이전에 뽑은 카드 3장의 합을 저장해둔 sum보다 크면서 M보다 작다면 이를 sum으로 다시 저장하여 준다.

마지막에는 결국 뽑을 수 있는 카드 3장의 합이 출력된다.