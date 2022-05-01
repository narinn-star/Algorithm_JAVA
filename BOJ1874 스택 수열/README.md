# [1874] 스택 수열

## 분류
> 자료 구조
>
> 스택

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());

		int last = 0;
		
		while(n-- > 0) {
			int val = Integer.parseInt(br.readLine());
			
			if(val > last) {
				for(int i = last + 1; i <= val; i++) {
					stack.push(i);
					sb.append('+').append("\n");
				}
				last = val;
			}
			else if(stack.peek() != val) {
				sb.delete(0, sb.length());
				sb.append("NO");
				break;
			}
			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}
```

## 문제풀이

문제도 겨우 이해해서 풀고있는 문제 .. 

거의 다 풀었는데 딱 하나가 이상하게 나온다. 하나 고치고 수열이 될 수 없는 경우에 "NO"가 출력되도록 하기만 하면 성공..!! 

---

너무 예제에 맞춤식으로 풀었던걸 다 지우고 새로 풀었다.

push 해줄 last만 계속 초기화 해주고, stack에 넣고 빼는 것은 그대로하고 else if()문만 넣어주면 된다. 이것도 딱히.. 크게 어려울건 없는데, pop 해주는 경우까지 계속 로직을 짜려고 하니 복잡해졌던 것 같다.

