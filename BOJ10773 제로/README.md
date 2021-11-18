# [4949] 균형잡힌 세상

## 분류
> 구현
>
> 자료 구조
>
> 스택

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0)
				stack.pop();
			else
				stack.push(input);
		}
		
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		bw.write(sum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

간단한 스택 문제

0이 입력될 때만 제일 위에 있는 것을 pop으로 꺼내주고, 그렇지 않을 때는 push로 스택에 넣어준다.

K번 실행한 후에 스택이 빌 때까지 sum에 pop한 값을 계속 더해주고 sum을 출력한다.