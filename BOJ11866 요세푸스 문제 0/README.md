# [11866] 요세푸스 문제 0

## 분류
> 구현
>
> 자료구조
>
> 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		
		String[] str = new String[2];
		str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
				
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(true) {
			int cnt = 1;

			if(queue.size() == 1)
				break;
			
			while(cnt < K) {
				int q = queue.poll();
				queue.add(q);
				cnt++;
			}
			
			if(cnt == K) {
				sb.append(queue.poll()).append(", ");
			}
		}
		sb.append(queue.poll()).append(">");
		System.out.println(sb);
	}
}
```

## 문제풀이

생각해보면 간단한 큐 문제이다. K번째에 있는 수를 빼서 저장한 다음 출력하면 된다. 

먼저 1부터 N까지의 수를 큐에 모두 넣어 숫자들을 준비한다. 그리고 while 반복문에서 원소들을 빼고 넣는 작업을 실행하는데, 큐 사이즈가 1일때 while문을 종료한다. 그 이유는 마지막에 ", " 없이 출력해야하기 때문이다. while문 안에서 cnt는 K번째를 확인해줄 인덱스 역할을 한다. cnt가 K보다 작을 떄 계속해서 원소를 빼고 다시 맨 끝에 넣은 후 cnt 값을 증가시킨다. 이를 반복하다 cnt값이 K와 같아지면 StringBuffer에 원소를 빼 ", "와 같이 저장해준다. 마지막에 큐 사이즈가 1일때 반복문을 종료하고는 마지막 원소를 뽑음과 동시에 ">"를 추가하여 출력하면 된다.

while문 안에서 조금 복잡하게 구현한 것 같아 아쉬움이 남는다. while 안에서 if는 필요없고, while문은 for문으로 대체하여 적을 수 있는 것을 조금 더 길게 짠 것 같다. 처음에 ", "도 \b를 이용해서 지우려 했는데 잘 적용되지 않는 것 같아 출력문은 검색을 통해 다시 수정했다.