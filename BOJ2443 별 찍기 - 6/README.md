# [2443] 별 찍기 - 6

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ2443 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for(int j = 0; j < (2 * N) - (2 * i + 1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

여섯번째 별찍기. 

다섯번째 별찍기는 1-3-5-7-9 ... 이번에는 ... 9-7-5-3-1 순서로 줄어드는 것을 알 수 있으므로 이에 맞게 반복문을 작성해주기만하면 된다. 지금까지 계속 증가하는 것으로 고집해서 풀고있는데 --로 풀어도 상관은 없다. 그냥 ++을 조금 더 많이 사용한다기에 습관을 들이려 이렇게 푸는 것 뿐..