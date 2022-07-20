# [10808] 알파벳 개수

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[26];
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < alpha.length; i++) {
			System.out.print(alpha[i] + " ");
		}
	}
}
```

## 문제풀이

charAt()함수로 한 문자씩 뜯어서 'a'를 빼주면 a는 0, b는 1 ... z는 25가 나오게 되고 이를 인덱스로 삼아 미리 만들어둔 int형 배열에 해당 인덱스 값을 증가시킨 후, for문을 이용해 하나씩 출력한다.

