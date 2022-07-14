# [10799] 쇠막대기

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

public class BOJ10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		
		String[] str = br.readLine().split("");
		int cnt = 0;
		for(int i = 0; i < str.length; i++) {
			if(str[i].equals("(")) {
				stack.push("(");
				continue;
			}
			if(str[i].equals(")")) {
				stack.pop();
				if(str[i-1].equals("(")) {
					cnt += stack.size();
				}
				else {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
```

## 문제풀이

체크할 것은 쇠막대기와 레이저 두 가지이다. 괄호가 바로 만들어지면 레이저, 그렇지 않으면 쇠막대기이다. 

'('가 온다면 우선 스택에 담고, ')'가 입력됐을 때 바로 앞의 값이 '('인지 ')'인지에 따라 레이저인지 쇠막대기인지 구분한다. 만약 바로 이전 문자가 '('라면 당연히 레이저인데, 여기서 막대기의 갯수를 어떻게 추가시키는지가 중요하다.

예제에서 ( ) ( ( ( ( ) ( ) )까지 입력이 되었다면 두번째 레이저에서 잘린 막대기의 수가 3개여야 하는데, 이는 스택에 들어있는 문자 '('가 3개인 것과 동일한 것을 알 수 있다. 이후 막대기의 끝을 알리는 괄호 없이 바로 또 레이저로 자르게 되면 막대기의 수가 3개 추가되는데 이 또한 스택의 size인 3과 동일하다.

만약 바로 이전 문자가 ')'라면 쇠막대기의 끝이므로 갯수를 하나 증가시킨다. 막대가 끝나면 이전의 레이저에서 잘려있을 것이기 때문에 하나를 추가해야한다. 