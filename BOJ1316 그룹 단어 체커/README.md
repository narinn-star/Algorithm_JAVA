# [1316] 그룹 단어 체커

## 분류
> 구현
>
> 문자열

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class BOJ1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		String[] str = new String[N];

		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		for (int i = 0; i < N; i++) {
			boolean[] check = new boolean[26];
			boolean ch = true;
			int tmp = 0;
			for (int j = 0; j < str[i].length(); j++) {
				int now = str[i].charAt(j);

				if (tmp != now) {
					if (check[now - 'a'] == false) {
						check[now - 'a'] = true;
						tmp = now;
					} else {
						ch = false;
						break;
					}
				}
			}
			if (ch)
				cnt++;
		}

		System.out.println(cnt);
	}
}
```

## 문제풀이

구글링으로 도움을 조금 받아 해결했다. 두 번만에 푼 문제..

생각해보면 딱히 어려운 문제는 아닌데 나는 반복문이 많아지거나 조건문이 많아질 것 같으면 끈기있게 잡고 풀어보는 습관이 들여지지 않은 것 같다. 귀찮아보여도 하나씩 체크해보며 풀어가는 습관을 길러야겠다.

우선 이 문제는 '체크'가 가장 중요한 역할을 한다. 쉽게 말해 방문체크라고 하면 되겠다. 단어 하나를 검사하기 전에 26개로 이루어진 boolean 배열을 만들어 두고 이미 단어 내에 있는 알파벳(int 값)을 배열에서 체크해주면 된다. 체크해주기 위해서는 당연히 변수가 두개 필요하다. 이전 값(tmp)과 현재 값(now)을 비교해서 같지 않을 때에만 비교해주면 된다. (같을 때는 아무것도 수행하지 않아도 됨.)

비교해줄 것은 앞서 말한대로 check 배열에 알파벳 여부를 체크해주고, 만약 이미 나왔던 알파벳이라면 그룹 단어가 아니기 때문에 변수 ch를 false로 초기화해 준 뒤 for문을 빠져나가면 된다. 

한 단어가 반복문을 빠져나가면 ch가 false인지 true인지 (ch의 초기값은 true) 확인한 후 true일 때만 (그룹 단어일 때만) 카운트 값을 올려주면 된다.