# [1259] 검증수

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.util.Scanner;

public class BOJ1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.next();
			StringBuffer sb = new StringBuffer(str);
			String tmp = sb.reverse().toString();
			
			if(str.equals("0")) {
				sc.close();
				return;				
			}
			
			if(str.equals(tmp))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
```

## 문제풀이

int형이지만 String으로 입력받아서 뒤집어주면 된다. 뒤집는 메소드 reverse()가 내장되어있는 클래스는 StringBuffer이기 때문에 입력받은 문자열을 넣고, tmp에 뒤집은 문자열을 담아준다.

만약 0이 나오면 바로 종료시키고, 그렇지 않을때는 tmp와 입력받은 문자열을 비교하여 같으면 yes, 다르면 no를 출력하도록 하는 간단한 문제이다.

sc.nextLine()을 사용했을 때에는 오류가 났는데, next()를 사용하니 오류가 나지 않는다. 

nextLine()은 문자 또는 문장 한라인 전체를 입력받는 것이고 next()는 문자 또는 문자열을 "공백"기준으로 한 단어 또는 한 문자씩 입력받는 것이다. 

nextLine을 사용했을 때 오류가 나는 이유는 아마도 버퍼에 문자열이 남아있기 때문인 것 같다. 사용하지 않는 문자열이 버퍼에 남겨져 있는 상태인데도 이와 같은 버퍼를 처리하지 않고 다시 입력을 받기 때문에 버퍼를 비워주어야 한다. 버퍼 처리 방법은 그냥 nextLine 메서드만 호출하면 된다.

이 문제에서는 next메서드로도 풀 수 있어 next로 풀었다.