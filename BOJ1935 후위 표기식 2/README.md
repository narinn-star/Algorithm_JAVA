# [1935] 후위 표기식 2

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

public class BOJ1935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		double[] arr = new double[N];
		Stack<Double> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		double res = 0;
		for(int i = 0; i < str.length(); i++) {
			if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				stack.push(arr[str.charAt(i) - 'A']);
			}
			else {
				if(!stack.isEmpty()) {
					double fir = stack.pop();
					double sec = stack.pop();
					
					switch(str.charAt(i)) {
					case '+':
						res = sec + fir;
						stack.push(res);
						continue;
					case '-':
						res = sec - fir;
						stack.push(res);
						continue;
					case '*':
						res = sec * fir;
						stack.push(res);
						continue;
					case '/':
						res = sec / fir;
						stack.push(res);
						continue;
					}
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}
```

## 문제풀이

예제에서 주어진 후위 표기식을 계산하려면 다음과 같다.

ABC*+DE/-  => (1 +(2 * 3)) - (4 / 5) = 6.20

스택에는 문자를 넣고, 나머지 연산자일 때는 switch-case문을 사용해 연산을 실행한다. 연산이 된 수는 스택에 넣어 다음 연산에서 사용한다.

값이 소수가 나올 수 있기 때문에 double형을 사용했고, 마지막 %.2f는 소수점 2번째까지 나타내기 위해 사용했다. 이때 print()나 println()이 아닌 printf()를 사용해야한다.

