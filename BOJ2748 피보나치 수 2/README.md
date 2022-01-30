# [2748] 피보나치 수 2

## 분류
> 수학
>
> 다이나믹 프로그래밍

## 코드
```java
import java.util.Scanner;

public class BOJ2748 {
	static long[] fibonacci = new long[91];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		fibonacci();
		System.out.println(fibonacci[n]);
		sc.close();
	}
	public static void fibonacci() {
		for(int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
		}
	}
}
```

## 문제풀이

DP.. 로 푸는줄 몰랐는데, 어제 Javascript로 피보나치 풀다가 바로 풀어내지 못한 내 자신에게 너무 실망스러워서 찾아 푼 문제.. 근데 또 틀렸다. 

첫번째는 0번째 수를 0이 아닌 1로 초기화해둔것.

두번째는 결괏값이 될 fibonacci 배열의 자료형을 int로 해둔것. 

결괏값이 int로는 모두 담을 수 없는 길이라, long으로 해야 90번째까지 담아낼 수 있다.

