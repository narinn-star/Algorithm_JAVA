# [2475] 검증수

## 분류
> 자료구조
>
> 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(true) {
			if(queue.size() == 1)
				break;
			queue.poll();	//버리기
			int move = queue.poll();  //옮길 수
			queue.add(move);		//옮기기
		}
		
		bw.write(queue.poll() + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

큐의 기본적인 문제

큐는 1 2 3 4를 넣었을 때 1부터 나오기 때문에 문제가 큐를 설명하고 있는 것과 다름이 없다. 1을 버리는 것은 poll()을 하여 그냥 빼내는 것이고, 두번째 동작인 제일 아래에 있는 카드 밑으로 옮기는 것은 출력 순서를 가장 마지막으로 해주는 것이므로 poll()해준 값을 저장해두고 다시 queue에 집어 넣으면 된다.

이를 queue size가 1이 될 때까지 실행해주면 된다.