# [2522] 별 찍기 - 12

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ2522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - i - 1; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < N - i - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
```

## 문제풀이

열두번째 별찍기. 

간단하게 풀 수 있으므로 설명은 생략─