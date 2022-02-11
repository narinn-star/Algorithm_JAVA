# [10990] 별 찍기 - 15

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ10990 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - i - 1; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 * i + 1; k++) {
				if(k == 0 || k == 2 * i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

열다섯번째 별찍기. 

다른 문제랑 다르게 왼쪽 오른쪽 모서리만 남겨두고 나머지는 공백이다.

우선 왼쪽 공백은 늘 하던데로 슝슝 찍어주고, 나머지 별은 규칙을 찾아주면, k가 0일때와 2 * i 일때만 별을 찍고 나머지는 모두 공백인 것을 알 수 있다. 피라미드 찍기에서 조건식만 넣어 공백, 별을 찍어주면 끝! 다른 문제랑 다르게 생각할 수 있는 별찍기여서 신선했던 문제!