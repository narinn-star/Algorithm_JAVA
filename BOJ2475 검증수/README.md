# [2475] 검증수

## 분류
> 수학
>
> 구현
>
> 사칙연산

## 코드
```java
import java.util.Scanner;

public class BOJ2475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			int a = sc.nextInt();
			sum += a * a;
		}
		System.out.println(sum % 10);
		sc.close();
	}
}
```

## 문제풀이

올리기엔 너무 부끄러울정도로 간단한 문제..

그냥 5번 반복해서 받은 후에 제곱한 수를 더해서 담아주고 출력할 때 10으로 나눈 나머지를 출력하면 된다.