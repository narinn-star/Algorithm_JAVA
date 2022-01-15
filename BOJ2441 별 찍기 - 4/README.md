# [2441] 별 찍기 - 4

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < N - i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

네번째 별찍기. 

문제 풀이는 생략─