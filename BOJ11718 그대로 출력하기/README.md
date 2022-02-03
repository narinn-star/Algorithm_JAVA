# [11718] 그대로 출력하기

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11718 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
	}
}
```

## 문제풀이

입력한 그대로 출력하는 것인데, 입력 수가 정해져있지 않다는 점을 주의해야한다. 

BufferedReader를 사용한다면 br.readLine()의 여부를, Scanner를 사용한다면 sc.hasNextLine()의 여부를 확인해주고 출력하면 된다.