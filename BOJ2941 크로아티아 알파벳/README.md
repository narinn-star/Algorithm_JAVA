# [2941] 크로아티아 알파벳

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.util.Scanner;

public class BOJ2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		int cnt = 0;

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (ch == 'c') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == '=')
						i++;
					else if (input.charAt(i + 1) == '-')
						i++;
				}
			}

			else if (ch == 'd') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == 'z') {
						if (i < input.length() - 2) {
							if (input.charAt(i + 2) == '=')
								i = i + 2;
						}
					} else if (input.charAt(i + 1) == '-')
						i++;
				}
			}

			else if (ch == 'l') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == 'j')
						i++;
				}
			}

			else if (ch == 'n') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == 'j')
						i++;
				}
			}

			else if (ch == 's') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == '=')
						i++;
				}
			}

			else if (ch == 'z') {
				if (i < input.length() - 1) {
					if (input.charAt(i + 1) == '=')
						i++;
				}
			}
			cnt++;
		}

		System.out.println(cnt);
		sc.close();
	}

}

```

## 문제풀이

간단한 구현 및 문자열 문제이다. 각 문자를 charAt()을 사용하여 조사한 후 갯수만 카운트해주면 된다.

주의해야할 점은 문자 2개나 문자 3개로 이루어진 크로아티아 알파벳을 조사할 때에는 문자의 길이가 적당하게(?) 남아있을 때 조사해야하는 것이다. 이것만 빼면 간단히 조건문만으로도 풀 수 있는 문제!