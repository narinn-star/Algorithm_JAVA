# [1152] 단어의 개수

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		System.out.println(st.countTokens());
	}
}
```

## 문제풀이

문자열만 다루는 문제를 오랜만에 봐서 그런지 어떻게 자를지 고민했다.

substring도 있고, split도 있고, StringTokenizer도 있고, 아니면 그냥 배열에 넣어 배열 길이를 출력하는 방법도 있다.

처음에 split을 이용해 배열에 넣고 예외 사항만 조건문으로 걸러준 후 제출했는데 ArrayIndexOutofBound 오류가 떴다. 구글링 해서 고쳤는데도 계속 오류가 떠서 이 방법은 포기하고, StringTokenizer class를 사용하기로 했다. 

간단하게 문자열을 받아 " "로 자르고 토큰 개수를 세어주었다.

확실히 class를 사용하니 깔끔하고 훨씬 낫다...