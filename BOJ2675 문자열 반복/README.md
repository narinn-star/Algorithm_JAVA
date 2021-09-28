# [2475] 검증수

## 분류
> 구현

## 코드
```java
import java.util.Scanner;

public class BOJ2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
 			
			int R = sc.nextInt(); 
			String S = sc.next();
			
			for(int j = 0; j < S.length(); j++) {
				for(int k = 0; k < R; k++) {
					System.out.print(S.charAt(j));
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
```

## 문제풀이

문자열을  R번 반복해서 출력하는 문제. 

주의할 점은 nextLine은 개행을 기준으로 공백까지 모두 문자열로 입력받고, next는 공백은 끊어서 문자열로 입력받는다. 여기서는 next로 쓰는게 맞다. 예제에서와 같이 반복문이 끝난 후에는 개행문자를 넣어야 한다.