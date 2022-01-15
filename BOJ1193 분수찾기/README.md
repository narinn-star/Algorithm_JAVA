# [1193] 분수찾기

## 분류
> 수학
>
> 구현

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int line = 1;
		int cnt = 0;
		
		while(true) {
			if(X <= cnt + line) {
				if(line % 2 == 0) {
					System.out.println((X - cnt) + "/" + (line - (X - cnt - 1)));
				}
				else
					System.out.println((line - (X - cnt - 1)) + "/" + (X - cnt));
				break;
			}
			else {
				cnt += line;
				line++;
			}
		}	
	}
}
```

## 문제풀이

나는 규칙 잘 안찾아지던데.. 구글링 하니까 다들 한눈에 보이는 규칙이래

아무튼 구글링해서 푼 문제다. 

우선 필요한 추가 변수는 line을 카운트해주는 line과 누적합을 저장할 cnt이다. 규칙을 보면 대각선 순서대로 2, 3, 4, 5 ... 로 늘어나는 것을 알 수 있고, cnt는 1, 3, 6 ... 로 각 line에서 가장 큰 수(번째)가 되는 것을 알 수 있다 (else문 한정)

이를 토대로, cnt + line이 X보다 작거나 같을 때 결과를 출력해야하므로 그 조건문 내에서 대각선 카운트 값이 홀수냐 짝수냐로 나누어 생각한다. 

짝수일 때는 분자는 X - 누적합, 분모는 대각선 값 - (X - 누적합 - 1)이고, 홀수일 때는 짝수일 때의 분자가 분모, 분모가 분자가 된다. 

사실 대각선 규칙도 알아내는데 한참이 걸렸는데 홀 짝 나누어 분모 분자를 구하는 수식도 한참이었다. 이건 수학이 모자란건지 구현이 모자란건지 잘 모르겠음..