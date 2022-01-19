# [2445] 별 찍기 - 8

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

여덟번째 별찍기. 

리본모양으로 별찍기를 하는 것. 부분부분 직각삼각형 또는 정삼각형으로 나누어보면 이전에 풀었던 별찍기를 모두 응용해서 합쳐놓은 것을 알 수 있다. 기본적인 별찍기 문제들은 직각삼각형 하나만 찍을줄 알아도 어렵지 않다.