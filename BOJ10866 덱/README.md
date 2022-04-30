# [10866] 덱

## 분류
> 자료 구조
>
> 덱

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");

			switch (input[0]) {
			case "push_front":
				deque.addFirst(Integer.parseInt(input[1]));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(input[1]));
				break;
			case "pop_front":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollFirst()).append("\n");
				}
				break;
			case "pop_back":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollLast()).append("\n");
				}
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if (deque.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "front":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekFirst()).append("\n");
				}
				break;
			case "back":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
```

## 문제풀이

ArrayDeque은 처음 사용해봤는데, Deque의 의미가 Double-ended Queue의 줄임말이라고 한다. 큐는 단방향이라면, 덱은 양방향으로 넣고 빼는 것이 가능하다. ArrayDeque에 사실 모두 구현되어 있기 때문에 알맞은 함수만 사용해주면 된다.