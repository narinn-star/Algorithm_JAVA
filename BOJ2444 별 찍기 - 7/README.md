# [2444] 별 찍기 - 7

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ2444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k < (N * 2) - (i * 2 + 2); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

일곱번째 별찍기. 

이전과는 줄 수가 달라졌다. 한번에 와다닥 찍기보단 N번째를 기준으로 위 아래를 나누어 찍어주면 된다. 5번째 + 6번째라고 생각하면 쉽다.