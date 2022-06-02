# [9020] 골드바흐의 추측

## 분류
> 수학
>
> 정수론
>
> 소수 판정
>
> 에라토스테네스의 체

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9020 {
	public static boolean[] prime = new boolean[10001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			Prime();
			int a = n/2, b = n/2;
			
			while(true) {
				if(!prime[a] && !prime[b]) {
					System.out.println(a + " " + b);
					break;
				}
				a--;
				b++;
			}
		}
	}
	
	public static void Prime() {
		prime[0] = prime[1] = true;
 
		for (int i = 2; i < Math.sqrt(prime.length) + 1; i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}
```

## 문제풀이

드디어 '에라토스테네스의 체'를 정확하게 이해했다. 늘 Math.sqrt(prime.length) + 1에 1을 더해주는 이유를 몰랐는데 그저 오차를 대비하기 위함이라고 한다. 에라토스테네스의 체를 이용해서 소수를 구해놓고 해야 할 일은 골드바흐의 파티션을 출력하는 것이다. 사실 어떻게 해야하나 고민 했는데, 설마 하는 마음으로 반으로 자른 후 빼고 더하기를 반복했더니 됐다.. a, b 중 a를 하나씩 감소시키고 b를 하나씩 증가시키는 이유는 문제에서 요구하는 바에 따르기 위함이다. "출력하는 소수는 작은 것부터 먼저 출력하며.." 

그리고 "파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다"라는 요구를 충족시키는 것 또한 a, b를 감소/증가시키는 것이 되고, 둘 다 소수일 경우에 출력한 후 break를 해주는 것 또한 이를 충족시킬 수 있다.

항상 알고리즘을 풀 때면 머릿 속에서는 쉬운데, 직접 키보드에 손을 얹으면 꽉 막히곤 했었다. 그런데 오늘은 설마하는 마음으로 풀어나갔는데 한 번에 풀려버려서 당황스럽기도 했지만, 그냥 자신있게 한번 쓰윽 써보는 것도 좋은 방법이라 생각했다.

