# [17413] 단어 뒤집기

## 분류
> 구현
>
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

public class BOJ17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		boolean check = false;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '<') {
				check = true;
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(str.charAt(i));
			}
			else if(str.charAt(i) == '>') {
				check = false;
				System.out.print(str.charAt(i));
			}
			else if(check) {
				System.out.print(str.charAt(i));
			}
			else if(!check) {
				if(str.charAt(i) == ' ') {
					while(!stack.isEmpty())
						System.out.print(stack.pop());
					System.out.print(str.charAt(i));
				}
				else
					stack.push(str.charAt(i));
			}
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop());
		
	}
}
```

## 문제풀이

무작정 뒤집으려고 StringBuffer에 넣어서 reverse()함수를 사용했더니.. 그냥 냅다 다 뒤집혀버렸다. 맨 끝을 빼고 공백을 넣어주는 것도 문제가 됐고, '<', '>' 두 괄호를 확인하는 작업도 까다로워서, 한 문자 한 문자 따로 파악해서 처리해주는 것이 낫겠다는 생각을 했다.

먼저 입력으로는 한 줄을 그대로 쭉 입력받은 후, charAt() 함수로 한 글자씩 괄호인지, 공백인지, 괄호 내의 문자인지 괄호 밖의 문자인지 조건문으로 확인한다. 

괄호 내의 문자인지 아닌지를 확인해주기 위해 boolean형 변수를 하나 생성하고, 괄호 내에 있을 때 즉, '<'를 만났을 때 true로 바꾸어주고 '>'를 만났을 때 false로 바꾸어준다. 괄호가 시작되면 스택에 있는 모든  문자를 거꾸로 출력한다. 시작태그라면 이전의 문자열이 있으면 거꾸로, 없다면 스택이 비었으므로 아무것도 출력하지 않을 것이고, 뒤의 태그라면 태그와 태그 사이에 있는 문자열을 거꾸로 출력하게 된다.

태그 내의 문자열은 boolean형 변수가 true인 상태이므로 stack에 담지 않고 charAt()함수로 문자를 출력하며, 태그 밖의 문자열은 공백을 만났을 때 이전에 담긴 스택의 문자를 꺼내고, 공백이 아니라면 스택에 넣어주기만 하면 된다. 넣고나면 이후에 스택에 담긴 문자를 꺼낼 때 정상적으로 꺼내지는 로직이 완성되기 때문이다.

반복문을 모두 돌고나서 stack에 남아있는 문자를 하나씩 꺼내어주기만 하면 끝난다.



여기서 포인트는 스택은 어차피 넣은 순서 반대로 꺼내어지기 때문에 '뒤집기'라는 말에 집중하기 보다는, 하나씩 구분해서 확인해주는 것이라 생각한다. 아마 뒤집기에 집중하느라 하나씩 체크하는 방법을 쉽게 떠올리지 못했기 때문이 아닐깡..