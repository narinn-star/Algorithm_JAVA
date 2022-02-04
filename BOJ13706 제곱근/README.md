# [13706] 제곱근

## 분류
> 수학
>
> 이분 탐색
>
> 임의 정밀도 / 큰 수 연산

## 코드
```java
import java.math.BigInteger;
import java.util.Scanner;

public class BOJ13706 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger N = sc.nextBigInteger();
		BigInteger start = new BigInteger("1");
		BigInteger end = N;
		BigInteger mid;
		
		while(true) {
			mid = start.add(end);
			mid = mid.divide(new BigInteger("2"));
			
			int res = (mid.multiply(mid)).compareTo(N);
			if(res == 0) break;
			else if(res == 1)
				end = mid.subtract(new BigInteger("1"));
			else
				start = mid.add(new BigInteger("1"));
		}
		
		System.out.println(mid.toString());
		sc.close();
	}
}
```

## 문제풀이

큰 수를 이용해야하는 것으로, BigInteger class를 사용한다. (Math.sqrt()는 double형을 반환)

사실, 이 문제가 이분탐색 문제인지는 알고리즘 분류를 봐서 아는 것이지 한눈에 알지는 못했다.

먼저 start(1)와 end(N)를 더해 2로 나눈 수를 mid로 두고 mid를 제곱한 수를 N과 비교하여 제곱근을 찾아 나간다. compareTo()는 int형을 반환하며, A == B일때 0, A > B 일때 1, A < B 일때 -1을 반환한다. 그러므로 res가 0이 되었을 때는 제곱근을 찾았기 때문에 반복문을 종료한다. mid가 N보다 클 때는 mid에서 1을 뺀 수를 끝 수(end)로 초기화하고 반대로 mid가 N보다 작을 때는 mid에서 1을 더한 수를 첫 수(start)로 초기화한다.

마지막에 반복문을 빠져나온 후에 mid를 출력하면 된다.

이분 탐색을 할 줄 모르는 것은 아니니 푸는데에는 큰 어려움은 없었다.