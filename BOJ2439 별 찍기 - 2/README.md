# [2439] 별 찍기 - 2

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

두번째 별찍기. 

같은 문제를 두번째 풀어보는 것마다 느끼는 거지만, 나름 짧은 시간안에 많은 성장을 했다고 생각한다. 아마 7-8까지는 이렇게 쉽게 풀어나갈 것으로 예상중 ..