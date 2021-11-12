# [2292] 벌집

## 분류
> 수학
>

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int i = 1;
		int cnt = 1;
		int tmp = 0;
		int x = 0;
        
		while(i < N) {
			tmp++;
			i++;
			if(tmp == 6 * (x+1) && (i - 1) % 6 == 0) {
				if(i == N)
					break;
				tmp = 0;
				cnt++;
				x++;
			}
		}
		if(N == 1)
			System.out.println(1);
		else
			System.out.println(cnt+1);
	}
}
```

## 문제풀이

N이 1일땐 무조건 1을 출력하게 하고 나머지는 cnt로 쌓아주다 출력하면 되는 간단한 문제.

이중 반복문으로 하려고 하니 범위를 계산하는 데에 어려움이 있어 while 반복문으로 해결했다. 

1은 1칸, 2~7은 2칸, 8~19는 3칸, 20~37은 4칸 38~61은 5칸 등 범위는 6의 배수로 커지는 것을 알 수 있다. 늘려줘야하는 값은 tmp, x,  i, cnt 까지 총 네개이다. 좀 더 간단하게 풀 수 있을 것 같은데 우선 내가 이해한 대로 풀기 위해서 변수를 많이 생성하게 된 것 같다.

잡아줘야 할 것은 i가 N과 같으면 cnt를 더해주지 않고 바로 출력해야하는 점이다.

간단한 수학 문제인데 너무 오래 잡고 있었던 것 같아 많이 아쉬웠던 문제.