# [11654] 아스키코드

## 분류
> 구현
>

## 코드
```java
import java.util.Scanner;

public class BOJ11654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int res = input.charAt(0);
		
		System.out.println(res);
	}
}
```

## 문제풀이

Scanner로는 char형을 받을 수 없기 때문에 문자열로 받아 끊어서 확인할 수 밖에 없다. charAt() 메서드로 입력문자를 아스키코드로 바꾸어 출력한다.

기본이지만 아스키코드는 int형이므로 문자를 바로 정수형으로 바꾸어 저장하면 된다.