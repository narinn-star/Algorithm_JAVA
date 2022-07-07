# [1406] 에디터

## 분류
> 자료 구조
>
> 스택
>
> 연결 리스트

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> lStack = new Stack<>();
		Stack<Character> rStack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			lStack.push(str.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			String[] line = br.readLine().split(" ");
			switch(line[0]) {
			case "L":
				if(!lStack.empty())
					rStack.push(lStack.pop());
				break;
			case "D":
				if(!rStack.empty())
					lStack.push(rStack.pop());
				break;
			case "B":
				if(!lStack.empty())
					lStack.pop();
				break;
			case "P":
				lStack.push(line[1].charAt(0));
				break;
			}
		}

		while(!lStack.isEmpty())
			rStack.push(lStack.pop());
		
		while(!rStack.isEmpty())
			sb.append(rStack.pop());
		System.out.println(sb);
	}
}
```

## 문제풀이

커서 위치를 어떻게 찾아줘야 할지 고민이 많이 됐다. 스택은 인덱스값을 사용해서 바로 지우고 넣고를 할 수가 없기 때문에, 커서를 기준으로 왼쪽 스택, 오른쪽 스택을 나누어 생각하기로 했다.

나중에 다 풀고나서 풀이비교를 해보니 링크 리스트를 사용하면 인덱스 값을 사용해서 바로 값을 넣고 뺄 수가 있었다.. 다음에 풀 때는 링크 리스트로 풀어보는 것도 좋을 것 같다.