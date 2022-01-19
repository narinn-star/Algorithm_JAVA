# [2446] 별 찍기 - 9

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (2 * N) - (2 * i + 1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < N - i - 1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (2 * i + 3); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

아홉번째 별찍기. 

이전에 했던 뒤집힌 삼각형과 삼각형을 합친것. 가운데 하나만 찍히는 것만 고려해주면 쉽게 푸는 별찍기.