# [2530] 인공지능 시계

## 분류
> 수학
>
> 사칙연산

## 코드
```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		int S = sc.nextInt();
		int D = sc.nextInt();
		
		S += D;				//초에 시간 모두 더하기
		M += S / 60;		//넘치는 초를 분으로 넘겨주기
		S %= 60;			//분으로 넘겨준 후의 나머지 값을 초로 초기화
		H += M / 60;		//넘치는 분을 시로 넘겨주기
		M %= 60;			//시로 넘겨준 후의 나머지 값을 분으로 초기화
		H %= 24;			//24시를 넘겼을 경우는 없기 때문에 나머지를 시로 초기화
		
		System.out.println(H + " " + M + " " + S);
	}
}
```

## 문제풀이

설명은 주석으로 모두 달아두었으므로 생략─