# [1065] 한수

## 분류
> 브루트포스 알고리즘

## 코드
```java
import java.util.Scanner;

public class BOJ1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0;

		if (N < 100) {
			System.out.println(N);
		} else {
			cnt = 99;

			for (int i = 110; i <= N; i++) {
				int hun = i / 100; // 2
				int ten = (i % 100) / 10; // 1
				int one = ((i % 100) % 10);	// 0
				
				if(hun - ten == ten - one) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
```

## 문제풀이

1부터 99까지는 모두 공차가 1 또는 0인 한수에 해당하므로, 입력하는 수 그대로 출력하고 100부터 110까지는 한수가 없으므로 110부터 for문을 시작하면 된다. 하나씩 자르고, 백의자리 - 십의자리 == 십의자리 - 일의자리 일때 한수에 해당하므로, cnt 값을 증가시킨다. cnt가 99인 이유는 110까지의 한수 개수가 99개인 것을 알 수 있기 때문.