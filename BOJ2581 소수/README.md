# [2581] 소수

## 분류
> 수학
>
> 정수론
>
> 소수 판정

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int i = M; i <= N; i++) {
			if(isPrime(i)) {
				array.add(i);
			}
		}
		
		for(int i = 0; i < array.size(); i++) {
			sum += array.get(i);
		}
		
		if(array.size() > 0) {			
			System.out.println(sum);
			System.out.println(array.get(0));
		}
		else
			System.out.println("-1");
	}
	
	public static boolean isPrime(int M) {
		if(M == 1)
			return false;
		for(int i = 2; i < M; i++) {
			if(M % i == 0)
				return false;
		}
		return true;
	}
}
```

## 문제풀이

내가 별로 좋아하지 않는 소수문제.. 사실 함수로 풀기 싫어서 그런게 아닐까 하는데, 몇번 풀다보니 이것도 푸는 방법이 딱 정해져있는 거라, 다음엔 이전만큼 꺼려하진 않을 것 같다.

isPrime 함수는 소수 판별하는 함수로, 다른 문제에서 소수판별하는것과 정말 똑-같다. 단지 이 문제에서는 소수인 것들의 합과, 최솟값을 출력해야한다. 합은 반복문에서 소수판별하는 즉시 더하면 되는데, 최솟값은 초기에 한번만 저장하는 방법은 잘 모르겠어서 배열에 하나씩 담기로했다. ArrayList 클래스를 사용해서 소수판별이 되면 배열에 담아주고, 소수판별이 모두 끝나면 sum에 배열에 담긴 수를 하나씩 꺼내어 더해주고, 합과 0번째에 들어있는 최솟값을 출력하였다. 

굳이 조건문으로 나누어준 이유는 소수가 없을 때 -1을 출력하기 위함이다. 이 때는 합과 최솟값은 출력하지 않아야하기 때문이다.