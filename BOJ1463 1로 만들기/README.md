# [1463] 1로 만들기

## 분류
> 다이나믹 프로그래밍

## 코드
```java
import java.util.Scanner;

public class BOJ1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
		}
		System.out.println(dp[N]);
		sc.close();
	}
}
```

## 문제풀이

다시 풀어보는 김에 다른 방법으로 풀어보고싶은데, 도저히 재귀로는 잘 모르겠다 아직.. 

dp가 늘 그렇듯 쭉 나열해서 규칙을 찾는 식으로 풀어냈다. 지난번에 풀었던 걸 열어보니까 소스가 아주 똑같아서 놀랐다.. 지난번엔 어떻게 이렇게 할 생각을 했는지는 모르겠지만 ㅎ

2부터 쌓아가면서 최솟값을 배열에 저장하는 방식으로 했다. 인덱스와 N의 값을 겹치게 해서 계산하면 뒤틀릴 일이 없어서 수월하다. 나누고 나서 카운팅 한 값이 더 작으면 그걸로, 그렇지 않으면 -1 해주고 카운팅한 값으로 최솟값을 저장하면 된다.