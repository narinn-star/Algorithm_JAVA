# [1158] 요세푸스 문제

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
import java.util.StringTokenizer;

public class BOJ1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		sb.append("<");
		while (!(queue.isEmpty())) {
			for (int i = 1; i <= K; i++) {
				if (i == K) {
					sb.append(queue.poll());
					if (queue.size() > 0)
						sb.append(", ");
				} else
					queue.add(queue.poll());
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}
```

## 문제풀이

큐로 풀면 되는 문제! 이제 StringBuilder도 제법 사용해봐서 그런지 바로 사용해야겠다는 생각이 들었다. 

먼저 큐에 1부터 N까지 모두 넣어두고, while 반복문 내에서 또 K만큼 반복문을 돌면서 하나씩 빼고 넣고 하면 된다. 출력해야하는 숫자만 출력하고 그렇지 않은 것은 빼자마자 다시 맨 뒤에 넣어주면 끝.

출력 형식에 맞추기 위해 queue.size() > 0 을 작성했다.