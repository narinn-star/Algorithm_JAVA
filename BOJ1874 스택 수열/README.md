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
		int[] arr = new int[n];
		int a = 0, pop;
		arr[a] = Integer.parseInt(br.readLine());
		for(int i = 1; i <= arr[0]; i++) {
			stack.push(i);
			sb.append("+").append("\n");
		}
		pop = stack.pop();
		sb.append("-").append("\n");
		a++;		
		while(a < n) {
			arr[a] = Integer.parseInt(br.readLine());
			if(arr[a] == pop - 1) {
				pop = stack.pop();
				sb.append("-").append("\n");
				a++;
			}
			else {
				for(int i = pop + 1; i <= arr[a]; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				pop = stack.pop();
				sb.append("-").append("\n");
				a++;
			}
		}
		System.out.println(sb);
	}
}
```

## 문제풀이

문제도 겨우 이해해서 풀고있는 문제 .. 

거의 다 풀었는데 딱 하나가 이상하게 나온다. 하나 고치고 수열이 될 수 없는 경우에 "NO"가 출력되도록 하기만 하면 성공..!! 

[수정중]