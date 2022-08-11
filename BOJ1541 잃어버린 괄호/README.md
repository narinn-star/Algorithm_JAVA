# [1541] 잃어버린 괄호

## 분류
> 수학
>
> 문자열
>
> 그리디 알고리즘
>
> 파싱

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sub = br.readLine().split("-");
		
		int sum = Integer.MAX_VALUE;
		
		for(int i = 0; i < sub.length; i++) {
			int tmp = 0;
			String[] add = sub[i].split("\\+");
			
			for(int j = 0; j < add.length; j++) {
				tmp += Integer.parseInt(add[j]);
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = tmp;
			}
			else {
				sum -= tmp;
			}
		}
		System.out.println(sum);			
	}
}
```

## 문제풀이

이 문제에서의 포인트는 '덧셈 먼저'이다. 가장 작은 수를 만들어내야 하기 때문에 큰 수들끼리 뺄셈을 해야한다. 만약 임의로 덧셈과 뺄셈이 섞인 식 (30 + 20 - 45  + 10 - 50)에서 가장 작은 수를 만들려면 다음과 같이 해야한다.

((30 + 20) - 45 + 10) - 50 = -35

덧셈을 먼저 다 수행하고 난 후에 뺄셈을 계산하는 것이다. 예제의 식 (55 - 50 + 40)도 이와 같은 방법으로 하면 55 - (50 + 40)으로, 답은 -35가 나온다. 

split() 안에 + 쓰고 거대한 오류를 만나면서 시간을 조금 끌긴 했지만, 구글링 해서 바로 고쳤다.

split()의 경우, 정규식을 받기 때문에 +를 넣게 되면 Pattern.SyntaxException을 뱉게 된다. 이는 + 문자가 메타문자이기 때문이라고 한다. +를 그대로 사용하고 싶을 땐 백슬래시를 사용하면 되는데, 백슬래시 또한 하나만 있으면 출력할 수 없기 때문에 백슬래시와 + 모두 이스케이프 하기 위해 + 앞에 백슬래시 두개를 사용하여 +를 분리해주는 것이다.

