# [10820] 문자열 분석

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10820 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while ((str = br.readLine()) != null) {
			int small = 0, big = 0, num = 0, space = 0;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c >= 'a' && c <= 'z')	small++;
				if (c >= 'A' && c <= 'Z')	big++;
				if (c >= '0' && c <= '9')	num++;
				if (c == ' ')	space++;
			}
			System.out.println(small + " " + big + " " + num + " " + space);
		}
	}
}
```

## 문제풀이

소문자, 대문자, 숫자, 공백 네가지로 구분하여 각 갯수를 출력한다.

소문자인지, 대문자인지, 숫자인지는 따로 구분하는 특별한 방법이 있는 것이 아니라 그냥 'a', 'A', '0' 이걸로만 구분해도 바로 된다. 이전에도 괜히 복잡한 방법 생각했다가 쉬운문제를 어렵게 풀려고 했던 것 같은데 그 때랑 똑같은 생각으로 돌아 돌아 풀었다..

