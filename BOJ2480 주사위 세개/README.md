# [2480] 주사위 세개

## 분류
> 수학
>
> 사칙연산

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2480 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] a = new int[3];
		int res = 0;
		
		for(int i = 0; i < 3; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		if(a[0] == a[1] && a[1] == a[2]) {
			res = 10000 + a[0] * 1000;
		}
		if(a[0] == a[1] && a[0] != a[2]) {
			res = 1000 + a[0] * 100;
		}
		if(a[0] == a[2] && a[0] != a[1]) {
			res = 1000 + a[0] * 100;
		}
		if(a[1] == a[2] && a[1] != a[0]) {
			res = 1000 + a[1] * 100;
		}
		if(a[0] != a[1] && a[1] != a[2] && a[0] != a[2]) {
			Arrays.sort(a);
			res = a[2] * 100;
		}
		System.out.println(res);
	}
}
```

## 문제풀이

조건문 연습문제인걸 알아서 그냥 냅다 조건문으로 다 때려 박아버렸다.

틀릴 수가 없는 구조라.. 설명은 딱히 필요하지 않을 것 같다.