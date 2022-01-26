# [1427] 소트인사이드

## 분류
> 문자열
>
> 정렬

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Integer[] num = new Integer[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			num[i] = str.charAt(i) - '0';
		}
		
		Arrays.sort(num, Collections.reverseOrder());
		
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
		br.close();
	}
}
```

## 문제풀이

Arrays.sort()를 사용하는 문제. 

내림차순은 Collections.reverseOrder()을 이용하면 한번에 뒤집을 수 있다.

다른 설명은 생략!