# [11050] 이항 계수 1

## 분류
> 수학
>
> 구현
>
> 조합론

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		int res1 = 1;
		int res2 = 1;
		
		for(int i = a; i > a - b; i--) {
			res1 *= i;
		}
		for(int i = b; i > 0; i--) {
			res2 *= i;
		}
		System.out.println(res1 / res2);
		br.close();
	}
}
```

## 문제풀이

오랜 시험기간 끝나고 대충 머리 식히는 용으로 푼 문제.

조합론이라는 게 이렇게 푸는것이 맞는건지는 잘 모르겠지만, 내가 nCr을 계산하는 방법 그대로 구현해보았다. 딱히 틀릴 내용도 없을뿐더러 어려운 내용도 아니었기에 머리 식히는 용으로도 되지 않았던 문제같다. 

대충 for 반복문만 사용하면 바로 구해낼 수 있는 쉬운 문제이다.