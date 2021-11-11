# [2231] 부분합

## 분류
> 브루트포스 알고리즘

## 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		
		for(int i = 0; i < N; i++) {
			int num = i;
			int sum = 0;
			
			while(num != 0) {
				sum += num % 10;
				num /= 10;
			}
			
			if(sum + i == N) {
				res = i;
				break;
			}
		}
		
		bw.write(res + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## 문제풀이

문제를 이해하는 게 조금 헷갈렸던 문제. 그 외에는 어렵지 않은 문제이다.

256의 생성자는 256 = 245 + 2 + 4 + 5 으로, 245이다. 예제에서 216의 생성자는 198 + 1 + 9 + 8 = 216 으로 198인데, 이 외에도 207 + 2 + 0 + 7 = 216으로 207이 생성자가 될 수도 있다. 생성자가 없을 수도 있고, 이처럼 여러개의 생성자를 가질 수도 있다. 문제에서 구하고자 하는 것은 가장 작은 생성자이기 때문에 작은 수부터 하나씩 비교해서 생성자가 맞으면 바로 출력하면 된다.

1부터 하나씩 검사하는 것이므로 1부터 자연수 N 까지 반복문을 실행하고, 각 자리 수의 합을 더해 그 합과 i를 더한 수가 자연수 N과 일치하면 반복문을 멈추고 출력한다.