# [9012] 괄호

## 분류
> 자료 구조
>
> 문자열
>
> 스택

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		boolean check;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] input = br.readLine().split("");
			Stack<Integer> stack = new Stack<>();
			check = true;
			
			for(int i = 0; i < input.length; i++) {
				if(input[i].equals("(")) {
					stack.push(1);
				}
				else if(input[i].equals(")")){
					if(stack.isEmpty()|| stack.peek() == null) {
						check = false;
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty())
				check = false;
			
			if(check) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}
```

## 문제풀이

처음 풀었을 때도 boolean 없이 풀려다가 출력이 잘 안됐던 것 같은데 또 똑같이 boolean 없이 풀고 있었다.

스택으로 '('일 때 아무 숫자나 push (스택에 뭐가 들어가는 지는 상관 없기 때문에) 하고, 만약 비어있거나 ( ')' 먼저 입력되었을 때) 모든 괄호를 push, pop을 다 해준 뒤에 스택이 비어있지 않다면 (짝을 다 찾아 줬는데 '('가 있을 때) false로 바꿔준다. 

새로 반복문이 시작되기 전에 check의 true/false 여부를 판단해 StringBuffer에 YES나 NO를 저장한다.

  

