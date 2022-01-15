# [2442] 별 찍기 - 5

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ2442 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - i - 1; j ++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}

```

## 문제풀이

다섯번째 별찍기. 

이전 별들과는 조-금 다른 식으로 풀어야하는 문제. 사실 2 * i + 1 말고는 다른게 없긴 하지만..