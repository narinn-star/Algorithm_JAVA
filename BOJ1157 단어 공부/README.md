# [2475] 검증수

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.util.Scanner;

public class BOJ1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] cnt = new int[26];
		int max = -1;
		int tmp = 0;
		char res = '?';
		String upper = str.toUpperCase();

		for (int i = 0; i < str.length(); i++) {
			tmp = (upper.charAt(i)) - 65;
			cnt[tmp]++;
		}

		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				res = (char) (i + 65);
			} else if (cnt[i] == max)
				res = '?';
		}
		System.out.println(res);
		sc.close();
	}
}
```

## 문제풀이

대/소문자 구분이 없고, 대문자로 출력해야하기 때문에 애초에 입력받은 문자들을 모두 대문자로 바꾸고 시작했다. 

배열은 알파벳 개수 26개로 선언하고 a -> 0 부터 z->25까지 해당 배열에 cnt를 계산해준다. 입력되지 않은 알파벳은 0으로 되어있기 때문에 max는 -1로 선언하고 cnt배열 안의 값과 max를 비교해 마지막에 출력할 res값을 ? 또는 해당 알파벳으로 설정한다.