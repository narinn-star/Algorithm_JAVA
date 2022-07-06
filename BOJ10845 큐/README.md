# [10845] 큐

## 분류
> 자료 구조
>
> 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int back = 0;
		
		while(N-- > 0) {
			String[] input = br.readLine().split(" ");
			
			switch(input[0]) {
			case"push":
				back = Integer.parseInt(input[1]);
				queue.add(back);
				break;
			case"pop":
				if(queue.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(queue.poll()).append("\n");
				break;
			case"size":
				sb.append(queue.size()).append("\n");
				break;
			case"empty":
				if(queue.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case"front":
				if(queue.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(queue.peek()).append("\n");
				break;
			case"back":
				if(queue.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(back).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
```

## 문제풀이

시간이 엄청 단축됐는데, 아마도 StringBuilder이 가장 영향이 큰 것 같다. 

back에 if/else문을 안넣어서 실패 한 번 뜨고 수정까지 했다.

하나씩 시간을 단축시키는 데에 재미를 붙여가는 중......