# [1676] 팩토리얼 0의 개수

## 분류
> 수학
>
> 임의 정밀도 / 큰 수 연산

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while(n >= 5) {
			cnt += n / 5;
			n /= 5;
		}
		System.out.println(cnt);
	}
}
```

## 문제풀이

알고리즘 분류를 안보고 풀어서 BigInteger를 사용하지 않고 규칙을 먼저 찾아야겠다는 생각이 들어 그렇게 풀었다. 

1!부터 쭉 소인수분해를 해서 보면, 0의 개수가 5의 배수일 때마다 증가하는 것을 알 수 있었다. 그래서 단순하게 0을 카운트 해주고 끝냈는데 틀리게 나왔다. 25, 125 등 5의 n승일 때는 2개씩 카운팅이 되기 때문에 한 개 더 추가해주면 된다. 