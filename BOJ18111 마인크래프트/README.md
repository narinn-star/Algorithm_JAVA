# [18111] 마인크래프트

## 분류
> 구현
>
> 브루트포스 알고리즘

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int B = Integer.parseInt(input[2]);
		int[][] ground = new int[N][M];

		int min = Integer.MAX_VALUE;
		int max = 0;

		int sec = Integer.MAX_VALUE, height = -1;

		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(row[j]);

				max = Math.max(max, ground[i][j]);
				min = Math.min(min, ground[i][j]);
			}
		}

		for (int k = min; k <= max; k++) {
			int t = 0;
			int block = B;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					int dif = ground[i][j] - k;
					
					if(dif > 0) {
						t += Math.abs(dif) * 2;
						block += Math.abs(dif);
					}else if(dif < 0) {
						t += Math.abs(dif);
						block -= Math.abs(dif);
					}
				}
			}
			if(block < 0)
				continue;
			if(sec >= t) {
				sec = t;
				height = k;
			}
		}
		System.out.println(sec + " " + height);
	}
}
```

## 문제풀이

이 문제 풀어보려 브루트포스 알고리즘 하나씩 다시 풀어봤다. 엄청 크게 도움이 된 것 같진 않지만, 브루트포스에 익숙해지려 했던 목적은 달성한 듯하다.

먼저 입력값은 넣어주고, 높이의 최솟값부터 최댓값까지 반복문을 실행한다. 시간은 t, 블록 갯수는 인벤토리에 있는 블록으로 초기화해준다. (0, 0)지점부터 차이를 계산한다. 값이 양수이면 블록을 제거해서 인벤토리에 넣는 작업을 하면서 시간도 2초 추가하고, 값이 음수이면 블록 하나를 꺼내는 작업을 하면서 시간 1초를 추가한다.  (0, 0)부터 (N, M)까지 모두 돈 후에 시간과 높이를 초기화하고 출력한다.