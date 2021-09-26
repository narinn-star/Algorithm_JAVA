# [11720] 숫자의 합

## 분류
> 수학
>
> 문자열
>
> 사칙연산

## 코드
```java
import java.util.Scanner;

public class BOJ11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String str = sc.next();
		int s = 0;
		
		for(int i = 0; i < N; i++) {
			char ch = str.charAt(i);
			s += (int)ch - '0';
		}
		System.out.println(s);
		sc.close();
	}
}
```

## 문제풀이

Scanner의 nextInt()는 개행되고 나서 입력되는 int값을 받기 때문에 여기서는 54321을 입력했을 때 숫자 하나로 인식하게 된다. 그래서 문자열로 받은 후, 문자로 자르고 int형으로 변환한 값을 합에 담았다. '0'을 빼준 이유는 아스키코드값이 그대로 나오기 때문이다.