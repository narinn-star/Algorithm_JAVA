# [10828] 스택

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

public class BOJ10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			String[] order = br.readLine().split(" ");
			switch(order[0]) {
			case"push":
				stack.push(Integer.parseInt(order[1]));
				break;
			case"pop":
				if(stack.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(stack.pop()).append("\n");
				break;
			case"size":
				sb.append(stack.size()).append("\n");
				break;
			case"empty":
				if(stack.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case"top":
				if(stack.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(stack.peek()).append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
}
```

## 문제풀이

1년만에 다시 풀어본 스택 가장 기초 문제. 

시간 변화가 416ms 에서 148ms까지 줄어들어 놀랐는데, 바뀐거라곤 StringBuilder와 push를 StringTokenizer가 아닌 배열로 받았다는 점 밖에 없다.

StringBuilder를 사용한 지는 그리 오래되지 않았는데, 시간단축에 큰 기여를 하는 걸 눈으로 확인했다.

스택 기본 구현이기 때문에 로직에 관해서는 따로 설명을 달진 않겠다.

