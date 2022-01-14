# [2440] 별 찍기 - 3

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
```

## 문제풀이

세번째 별찍기. 

문제 풀이는 생략─