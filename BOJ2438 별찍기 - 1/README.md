# [2438] 별 찍기 - 1

## 분류
> 구현

## 코드
```java
import java.util.Scanner;

public class BOJ2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

.. 별찍기 하나씩 부수려고 시작한 문제

1년 전에 C로 풀었는데 감회가 새로운 느낌

작년엔 뭐가 그리 어려웠는지 많이 헤맸던 기억이 났당..