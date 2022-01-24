# [2523] 별 찍기 - 13

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ2523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < N - i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

열세번째 별찍기. 

설명은 생략─