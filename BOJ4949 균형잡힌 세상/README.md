# [4949] 균형잡힌 세상

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

public class BOJ4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.charAt(0) == '.')
				break;
			System.out.println(func(str));		
		}
	}
	
	static public String func(String str) {	
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(' || c == '[')
				stack.push(c);
			else if(c == ')') {
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}		
				else
					stack.pop();
			}
			else if(c == ']') {
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else
					stack.pop();
			}	
		}
		
		if(stack.isEmpty())
			return "yes";
		else
			return "no";
	}
}
```

## 문제풀이

처음에 하나씩 조건문으로 잡다가 한계가 있어 데이터구조 수업시간에 스택을 배웠던 것을 떠올려 이렇게 풀게 되었다. 

우선 왼쪽 소괄호를 넣는 데에는 제한이 없기 때문에 스택에 무조건 집어넣어주면 된다. 오른쪽 소괄호일 때가 문제인데, )를 닫아줄 차례에는 스택에 담겨있는 것이 (인지 확인해야하고, ]를 닫아줄 차례에는 스택에 담겨있는 것이 [인지 확인해야 한다. 그와 동시에 오른쪽 괄호는 무조건 꺼내는 것이기 때문에 비어있을 경우에는 뺄 것도 없으므로 바로 no로 리턴하면 된다.

문자열 길이만큼 검사가 끝나게 되면 스택이 비었는지 확인하고 비었으면 모든 괄호가 정상적으로 다 닫혔다는 뜻이므로 yes를, 그렇지 않은 경우는 아직 덜 닫힌 괄호가 있다는 뜻이므로 no를 반환한다. 

종료 조건은 main에서 while문 안에서 str이 .일 경우 break하도록 작성한다.