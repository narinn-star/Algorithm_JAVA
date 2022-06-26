# [9093] 단어 뒤집기

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9093 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb;
		StringBuffer print = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] str = br.readLine().split(" ");
			
			for(int i = 0; i < str.length; i++) {
				sb = new StringBuffer();
				sb.append(str[i]);
				sb.reverse();
				print.append(sb).append(" ");
			}
			print.append("\n");
		}
		System.out.println(print);
	}
}
```

## 문제풀이

reverse()함수로 푼 기억은 분명하게 있는데 어디에 내장되어있는 함수인지 기억이 안나서 내가 제출한 코드를 조금 참고했다. 배열 관련 클래스 내장 함수인 줄 알았는데, StringBuffer에 내장된 함수 reverse()를 사용해서 단어를 뒤집었다.

이전과 달라진 점은 while문을 사용해서 깔끔하게 반복문을 실행하는 것, StringBuffer를 출력할 때 자연스럽게 사용 하는 것 그리고 굳이 StringTokenizer를 사용해서 단어를 자르지 않는 것.

배열 개수를 지정하지 않은 채 선언과 동시에 값을 넣어줄 수 있는 장점을 이용할 때마다 자바의 유용함을 느끼는 것 같다.

reverse()함수를 사용할 sb를 main에서 선언과 동시에 초기화를 해주었기 때문에 반복문을 돌면서 계속해서 버퍼에 쌓여 출력했을 때 오만가지 단어들이 다 튀어나왔다. 당연히 한 단어씩 뒤집어야하는 문제이기 때문에, for문 내에서 초기화해주는 것이 맞다.

